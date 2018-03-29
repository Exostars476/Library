import { Component, OnInit } from '@angular/core';
import { LogoutService } from '../../service/logout.service';
import { MessagesService } from '../../service/messages.service';
import { Router } from '@angular/router';
import { LocalStorageService, LocalStorage} from 'ngx-webstorage';

@Component({
  selector: 'navbar-logged-admin',
  templateUrl: './navbar-logged-admin.component.html',
  styleUrls: ['./navbar-logged-admin.component.css']
})
export class NavbarLoggedAdminComponent implements OnInit {

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
