import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Playlist } from './playlist';

@Injectable({
  providedIn: 'root'
})
export class PlaylistService {

  private HttpServicePlaylist:HttpClient;
  private target:string;

  constructor(param_service_playlist:HttpClient) {
    this.HttpServicePlaylist = param_service_playlist;
    this.target = environment.domain + "playlist/";
   }

   public getPlaylist():Observable<Playlist[]> {
     const promesse_server:Observable<any> = this.HttpServicePlaylist.get(this.target);
     const treament =(data:any):Playlist[]=>{
       return data as Playlist[];
     };
     return promesse_server.pipe(map(treament));
   }

   public getById(p_id:number):Observable<Playlist>{
     return this.HttpServicePlaylist.get(this.target + p_id).pipe(
       map(
         (param_response:any) => {
           return param_response as Playlist;
         }
       )
     );
   }

   public addPlaylist(p_play:Playlist):Observable<Playlist>{
     return this.HttpServicePlaylist.post(this.target, p_play).pipe(
       map(
         (param_response:any)=>{
           return param_response as Playlist;
         }
       )
     );
   }

   public editPlaylist(p_play:Playlist, p_id:number):Observable<Playlist>{
     return this.HttpServicePlaylist.put(this.target + p_play, p_id).pipe(
       map(
         (param_response:any)=>{
           return param_response as Playlist;
         }
       )
     );
   }

   public deletePlaylist(p_id:number):Observable<Playlist>{
     return this.HttpServicePlaylist.delete(this.target + p_id).pipe(
       map(
         (param_response:any)=>{
           return param_response as Playlist;
         }
       )
     );
   }
}
