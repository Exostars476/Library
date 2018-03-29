import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { BookComponent } from './book/book.component';
import { AddBookComponent } from './book/add-book/add-book.component';
import { BookDetailComponent } from './book/book-detail/book-detail.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { AdministrationComponent } from './administration/administration.component';
import { MemberComponent } from './member/member.component';
import { IsNotAdminComponent} from './is-not-admin/is-not-admin.component';
import { IsNotConnectedComponent} from './is-not-connected/is-not-connected.component';
import { AddMemberComponent } from './member/add-member/add-member.component';
import { DeleteMemberComponent } from './member/delete-member/delete-member.component';
import { UpdateMemberComponent } from './member/update-member/update-member.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { SearchComponent } from './search/search.component';

const routes: Routes = [
    { path: 'books', component: BookComponent },  
    { path: 'book/add', component: AddBookComponent }, 
    { path: 'book/detail/:bookId', component: BookDetailComponent }, 
    { path: 'home', component: HomeComponent },
    { path: 'login', component: LoginComponent },
    { path: 'logout', component: LogoutComponent },
    { path: 'administration', component: AdministrationComponent },
    { path: 'members', component: MemberComponent },
    { path: 'member/add', component: AddMemberComponent },
    { path: 'member/update', component: UpdateMemberComponent },
    { path: 'member/delete/:memberId', component: DeleteMemberComponent },
    { path: 'notAdmin', component: IsNotAdminComponent },
    { path: 'notConnected', component: IsNotConnectedComponent },
    { path: 'search/:recherche', component: SearchComponent },
    { path: '', redirectTo:'/home', pathMatch:'full'},
    { path: '**', component: PageNotFoundComponent }
]

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports:[RouterModule],
  declarations: []
})
export class AppRoutingModule { }
