import { Component, OnInit } from '@angular/core';
import {MessagesService} from '../service/messages.service';

@Component({
  selector: 'app-page-not-found',
  templateUrl: './page-not-found.component.html',
  styleUrls: ['./page-not-found.component.css']
})
export class PageNotFoundComponent implements OnInit {

  constructor(private msService: MessagesService) { }

  ngOnInit() {
    this.msService.displayFailureMessage("Sorry page not found");
    console.log("in pagenot foind compoenent init");
  }
  
}
