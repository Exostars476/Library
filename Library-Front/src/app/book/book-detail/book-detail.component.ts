import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BookBackService } from '../../service/bookBack.service';
import { EditorBackService } from '../../service/editorBack.service';
import { CategoryBackService } from '../../service/categoryBack.service';
import { AuteurBackService } from '../../service/auteurBack.service';
import { BookVM } from '../../model/BookVM';
import { EditorVM } from '../../model/EditorVM';
import { AuteurVM } from '../../model/AuteurVM';
import { CategoryVM } from '../../model/CategoryVM';

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent implements OnInit {

  date1 = new Date('December 17, 1995 03:24:00');
  idBook: number;
  book: BookVM = {  
    bookId: 0,
    bookTitle: "",
    description: "",
    price: 0,
    authorsId: [],
    categoryId: 0,
    editorId: 0,
    pubDate: this.date1,
    popular: false,
    imagePath: ""
  };
  editor: EditorVM = {
    id: 0,
    name: "",
    editorAddress: "",
    booksId: []
  };
  category: CategoryVM = {
    name: "",
    description: "",
    booksId: []
  };
  auteurs: AuteurVM[] = [];
  i = 0;
  editorId:number;
  categoryId:number;
  authorsId: number[];

  constructor(private route: ActivatedRoute,
    private bookBack: BookBackService,
    private editorBack: EditorBackService,
    private categoryBack: CategoryBackService,
    private auteurBack: AuteurBackService ) { 
  }

  ngOnInit() {
    this.idBook = + this.route.snapshot.paramMap.get('bookId');
    this.bookBack.getBook(this.idBook).subscribe(
      data => {
        this.bookBack.handleData(data);
        if(data.payload){
          this.book = data.payload; 
          this.editorId = this.book.editorId;
          this.categoryId = this.book.categoryId;
          this.authorsId = this.book.authorsId;  
        }
        this.editorBack.getEditor(this.editorId).subscribe(editorData => {
            this.editorBack.handleData(editorData);
            if(editorData.payload){
              this.editor = editorData.payload;
            }
          })
          this.categoryBack.getCategory(this.categoryId).subscribe(categoryData => {
            this.categoryBack.handleData(categoryData);
            if(categoryData.payload){
              this.category = categoryData.payload;
            }
          })
          this.authorsId.forEach(element => {
            this.auteurBack.getAuteur(element).subscribe(authorData => {
              this.auteurBack.handleData(authorData);
              if(authorData.payload){               
                this.auteurs[this.i-1] = authorData.payload;
              }
            })
            this.i = this.i + 1;
          });
      },
      error => {
        console.error(error.message);
        //messageService.displayFailureMessage(error.message);
      }
    )
  }

}
