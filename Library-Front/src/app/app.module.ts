import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './/app-routing.module';
import { MessagesComponent } from './messages/messages.component';
import { MessagesService } from './service/messages.service';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { BookComponent } from './book/book.component';
import { LoginComponent } from './login/login.component';
import { AdministrationComponent } from './administration/administration.component';
import { MemberComponent } from './member/member.component';
import { AddMemberComponent } from './member/add-member/add-member.component';
import { AddBookComponent } from './book/add-book/add-book.component';
import { UpdateMemberComponent } from './member/update-member/update-member.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { HttpClientModule } from '@angular/common/http';
import { ConfigComponent } from './config/config.component';
import { BackendService } from './service/backend.service';
import { MemberBackService } from './service/memberBack.service';
import { LogoutService } from './service/logout.service';
import { BookBackService } from './service/bookBack.service';
import { EditorBackService } from './service/editorBack.service';
import { CategoryBackService } from './service/categoryBack.service';
import { AuteurBackService } from './service/auteurBack.service';
import { DatashareService } from './service/datashare.service';
import { NavbarLoggedComponent } from './navbar/navbar-logged/navbar-logged.component';
import { NavbarLoggedAdminComponent } from './navbar/navbar-logged-admin/navbar-logged-admin.component';
import { HeaderComponent } from './header/header.component';
import { LogoutComponent } from './logout/logout.component';
import { RecBookComponent } from './book/rec-book/rec-book.component';
import { BookDetailComponent } from './book/book-detail/book-detail.component';
import { UpdateBookComponent } from './book/update-book/update-book.component';
import { DeleteMemberComponent } from './member/delete-member/delete-member.component';
import { CustomInterceptor } from './customInterceptor.service';
import { LocalStorageService } from 'ngx-webstorage';
import { IsNotAdminComponent } from './is-not-admin/is-not-admin.component';
import { IsNotConnectedComponent } from './is-not-connected/is-not-connected.component';
import { SearchComponent } from './search/search.component';
@NgModule({
  declarations: [
    AppComponent,
    MessagesComponent,
    NavbarComponent,
    FooterComponent,
    HomeComponent,
    BookComponent,
    LoginComponent,
    AdministrationComponent,
    MemberComponent,
    AddMemberComponent,
    AddBookComponent,
    UpdateMemberComponent,
    PageNotFoundComponent,
    ConfigComponent,
    NavbarLoggedComponent,
    NavbarLoggedAdminComponent,
    HeaderComponent,
    LogoutComponent,
    RecBookComponent,
    BookDetailComponent,
    UpdateBookComponent,
    DeleteMemberComponent,
    IsNotAdminComponent,
    IsNotConnectedComponent,
    SearchComponent
  ],
  entryComponents:[NavbarComponent],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [ {
     provide: HTTP_INTERCEPTORS,
     useClass: CustomInterceptor,
     multi: true
   },BackendService, 
   MessagesService, 
   DatashareService, 
   MemberBackService, 
   BookBackService, 
   EditorBackService, 
   CategoryBackService, 
   AuteurBackService, 
   LocalStorageService, 
   LogoutService],
  bootstrap: [AppComponent]
})
export class AppModule { }
