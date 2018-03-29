import { Component, OnInit } from '@angular/core';
import { Member } from '../../model/member';
import { MessagesService } from '../../service/messages.service';
import { MemberBackService } from '../../service/memberBack.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-delete-member',
  templateUrl: './delete-member.component.html',
  styleUrls: ['./delete-member.component.css']
})
export class DeleteMemberComponent implements OnInit {

  idMember:number;

  constructor(private memberBack: MemberBackService,
  private MessagesService: MessagesService,
  private route: ActivatedRoute,
  private router: Router) { }

  ngOnInit() {
    this.idMember = + this.route.snapshot.paramMap.get('memberId');
    this.memberBack.deleteMember(this.idMember).subscribe(data => {
        console.log("test");
        this.router.navigate(['/members']);
      }
    )
  }
}
