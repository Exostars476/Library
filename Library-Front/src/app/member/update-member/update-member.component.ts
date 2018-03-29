import { Component, OnInit } from '@angular/core';
import { LocalStorageService } from 'ngx-webstorage';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-member',
  templateUrl: './update-member.component.html',
  styleUrls: ['./update-member.component.css']
})
export class UpdateMemberComponent implements OnInit {

  constructor(private storage: LocalStorageService,
  private router: Router) { }

  ngOnInit() {
    if(this.storage.retrieve('me')){
      if(this.storage.retrieve('me').access !== 1){  
        this.router.navigate(['/notAdmin']); 
      }
    }else{
      this.router.navigate(['/notConnected']); 
    } 
  }

}
