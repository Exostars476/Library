import { Component, OnInit } from '@angular/core';
import { BookVM } from '../model/BookVM';
import { AuteurVM } from '../model/AuteurVM';
import { EditorVM } from '../model/EditorVM';
import { CategoryVM } from '../model/CategoryVM';
import { MessagesService } from '../service/messages.service';
import { Router } from '@angular/router';
import { BookBackService } from '../service/bookBack.service';
import { AuteurBackService } from '../service/auteurBack.service';
import { EditorBackService } from '../service/editorBack.service';
import { CategoryBackService } from '../service/categoryBack.service';
declare var jquery:any;
declare var $ :any;
@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
   
  book: BookVM[];

  constructor(private bookBack: BookBackService,
    private MessagesService: MessagesService,
    private router: Router) { }

  ngOnInit() {
    this.getBooks();
  }

  returnTop(){
     $('#returntop').click(function () {
        $('html, body').animate({scrollTop:0}, 'slow');
        return false;
    });
  }

  getBooks(){
    this.bookBack.getBooks().subscribe(
      data => {
        this.bookBack.handleData(data);
        if(data.payload){
          this.book = data.payload;
        }
      },
      error => {
        console.error(error.message);
        //messageService.displayFailureMessage(error.message);
      }
    )
  }
}
