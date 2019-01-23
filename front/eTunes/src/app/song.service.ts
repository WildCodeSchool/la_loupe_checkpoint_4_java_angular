import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {map} from "rxjs/operators";
import {Http, Response, RequestOptionsArgs} from '@angular/http';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Song } from './song';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SongService {

  private target:string;
  private httpService:Http;
  private httpServiceClient:HttpClient;

  constructor(httpService:Http, client:HttpClient) { 
    this.httpService = httpService;
    this.target = environment.domain + "songs/";
    this.httpServiceClient = client;
  }


  // GET
  public getSongs():Observable<Song[]>{

    return this.httpService.get(this.target).pipe(
      map(
          (p_response:Response) => {
          const songs: Song[] = p_response.json();
          return songs;
        }
      )
    );
  }

  //  CREATE
  public addSong( song:Song ):Observable<Song>{

    return this.httpService.post(this.target, song ).pipe(
      map(
          (p_response:Response) => {
          return p_response.json() as Song;
        }
      )
    );
  }

  // UPDATE
  public editSong( id:number, song:Song ):Observable<Song>{
    return this.httpService.put(  this.target  + id , song ).pipe(
      map(
        ( p_response:any ) => {
          return p_response as Song;
        }
      )
    );
  }

  // DELETE
  public deleteSong( id:number ):Observable<boolean>{
    return this.httpService.delete(  this.target  + id ).pipe(
      map(
        ( p_response:any ) => {
          console.log(p_response);
          return p_response as boolean; 
        }
      )
    );
  }



}
