import { Component, OnInit } from '@angular/core';
import { MessagesService } from '../service/messages.service';
import { Router } from '@angular/router';
import { BookBackService } from '../service/bookBack.service';
import { BookRecVM } from '../model/BookRecVM';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'] 
})
export class HomeComponent implements OnInit {

  book: BookRecVM[];

  constructor(private bookBack: BookBackService,
    private MessagesService: MessagesService,
    private router: Router) { }

  ngOnInit() {
    this.getRecBooks();
  }

  getRecBooks(){
    this.bookBack.getBookRec().subscribe(
      data => {
        this.bookBack.handleData(data);
        if(data.payload){
          this.book = data.payload;
          console.log(data.payload);
        }
      },
      error => {
        console.error(error.message);
        //messageService.displayFailureMessage(error.message);
      }
    )
  }
}
