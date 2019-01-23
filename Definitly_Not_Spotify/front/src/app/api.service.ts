import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

import { environment } from "../environments/environment"


@Injectable({
  providedIn: 'root'
})
export class ApiService {

   private client:HttpClient;

   constructor(client:HttpClient) {
      this.client = client;
   }

  public apiGet(request:string):Observable<any>{
      const promise:Observable<any> = this.client.get(environment.apiurl + request)

      const treatment = (data:any):any => {
      return data;
      };

      return promise.pipe( map( treatment )).pipe(catchError(() => {
         return throwError("GET request failed");
      }));
   }

   public apiPost(request:string, body:any):Observable<any>{
      const promise:Observable<any> = this.client.post<any>(environment.apiurl + request, body)

      const treatment = (data:any):any => {
      return data;
      };

      return promise.pipe( map( treatment )).pipe(catchError(() => {
         return throwError("POST request failed");
      }));
   }

   public apiPut(request:string, body:any):Observable<any>{
      const promise:Observable<any> = this.client.put<any>(environment.apiurl + request, body)

      const treatment = (data:any):any => {
      return data;
      };

      return promise.pipe( map( treatment )).pipe(catchError(() => {
         return throwError("PUT request failed");
      }));
   }

   public apiDelete(request:string):Observable<any>{
      const promise:Observable<any> = this.client.delete(environment.apiurl + request)

      const treatment = (data:any):any => {
      return data;
      };

      return promise.pipe( map( treatment )).pipe(catchError(() => {
         return throwError("DELETE request failed");
      }));
}
}
