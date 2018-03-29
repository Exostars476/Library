import { Component, OnInit } from '@angular/core';
import { LogoutService } from '../../service/logout.service';
import { MessagesService } from '../../service/messages.service';
import { Router } from '@angular/router';
import { LocalStorageService, LocalStorage} from 'ngx-webstorage';

@Component({
  selector: 'navbar-logged',
  templateUrl: './navbar-logged.component.html',
  styleUrls: ['./navbar-logged.component.css']
})
export class NavbarLoggedComponent implements OnInit {

  constructor(private logoutService:LogoutService, private router: Router, private storage: LocalStorageService) { }

  ngOnInit() {
  }

  search(recherche:string){
    this.router.navigate(['/search/'+ recherche]);      
  }

  logout(){
    this.logoutService.logout();
    
  }
}
