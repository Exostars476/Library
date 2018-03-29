import { Injectable } from '@angular/core';
import {
 HttpRequest,
 HttpHandler,
 HttpEvent,
 HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { LocalStorageService } from 'ngx-webstorage';

@Injectable()
export class CustomInterceptor implements HttpInterceptor {

   constructor(private storage:LocalStorageService) {
   }

   intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

       request = request.clone({
           withCredentials: true
       });

       return next.handle(request);
   }
}