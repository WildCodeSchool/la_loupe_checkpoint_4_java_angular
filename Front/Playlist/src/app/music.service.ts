import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Playlist } from './playlist';
import { HttpClient } from '@angular/common/http';
import { map } from "rxjs/operators";


@Injectable({
  providedIn: 'root'
})
export class MusicService {
  private myHttpService: HttpClient;
  private target: string;

  constructor(param_service: HttpClient) {
    this.myHttpService = param_service;
    this.target = environment.domain + "playlists/";
   }

   public getPlayContenu():Observable<Playlist[]>{
     const server:Observable<any> = this.myHttpService.get(this.target);
     const treatment = (data:any): Playlist[] =>{
       return data as Playlist[];
     };
     return server.pipe(
       map(treatment)); 
   }

   public getPLayById(p_id:number):Observable<Playlist>{
     const server_id:Observable<any> = this.myHttpService.get(this.target + p_id)
     const treatment = (data:any):any => {
       return data as Playlist;
     };
     return server_id.pipe(map(treatment));
   }

   public addPlay(p_play:Playlist):Observable<Playlist>{
     return this.myHttpService.post(this.target, p_play).pipe(
       map((param_response:any)=> {
         return param_response as Playlist
       })
     );
   }

   public editPlay(p_id:number, p_play):Observable<Playlist>{
     return this.myHttpService.put(this.target+p_id, p_play).pipe(
       map((param_response)=>{
         return param_response as Playlist;
       })
     );
   }

   public deletePlay(p_id:number):Observable<boolean>{
     return this.myHttpService.delete(this.target + p_id).pipe(
       map((param_response) => {
         return param_response as boolean;
       })
     );
   }
}
