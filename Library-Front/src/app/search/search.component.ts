import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LocalStorageService } from 'ngx-webstorage';
import { BookVM } from '../model/BookVM';
import { BookBackService } from '../service/bookBack.service';
import 'rxjs/add/operator/filter';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

   books: BookVM[];

  constructor(private route: ActivatedRoute, private storage: LocalStorageService, private bookService: BookBackService) { 
    this.route.params.subscribe(params => this.search(params["recherche"]));
  }

  ngOnInit() {
  }

  search(recherche:string){
    this.bookService.getSearchedBooks(recherche).subscribe(
      data => {
        console.log("recherche : ");
        console.log(recherche);
        console.log("Payload : ");
        console.log(data);
        this.books = data;
      },
      error => {
        console.error(error.message);
        //messageService.displayFailureMessage(error.message);
      }
    )
  }
}
