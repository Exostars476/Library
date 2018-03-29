import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LocalStorageService } from 'ngx-webstorage';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  default = true;
  logged = false;
  admin = false;

  constructor(private http: HttpClient,
  private storage: LocalStorageService) { }  

  ngOnInit() {    
    if(this.storage.retrieve('me')){
      this.logged = true;
      this.default = false;
      if(this.storage.retrieve('me').access == 1){
        this.admin = true;
        this.logged = false;     
      }
    }
  }
}
