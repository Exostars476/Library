import { Component, OnInit } from '@angular/core';
import { LogoutService } from '../service/logout.service';
import { MessagesService } from '../service/messages.service';
import { Router } from '@angular/router';
import { LocalStorageService, LocalStorage} from 'ngx-webstorage';

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private router: Router, private storage: LocalStorageService) { }

  ngOnInit() {
  }

  search(recherche:string){
    this.router.navigate(['/search/'+ recherche]);      
  }
}
