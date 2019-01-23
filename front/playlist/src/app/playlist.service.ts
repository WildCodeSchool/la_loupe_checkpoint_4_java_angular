import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { environment } from "src/environments/environment.prod";
import { Observable } from "rxjs";
import { Playlist } from "./playlist";
import { map } from "rxjs/operators";

@Injectable({
  providedIn: "root"
})
export class PlaylistService {
  private HttpservicePlaylist: HttpClient;
  private target: string;

  constructor(param_service_play: HttpClient) {
    this.HttpservicePlaylist = param_service_play;
    this.target = environment.domaine + "playlists/";
  }

  public getPlayl(): Observable<Playlist[]> {
    const promesse_server: Observable<any> = this.HttpservicePlaylist.get(
      this.target
    );
    const treatment = (dataPlay: any): any => {
      return dataPlay as Playlist[];
    };
    return promesse_server.pipe(map(treatment));
  }

  public getById(p_id: number): Observable<Playlist> {
    return this.HttpservicePlaylist.get(this.target + p_id).pipe(
      map((param_response: any) => {
        return param_response as Playlist;
      })
    );
  }

  public addChan(p_chan: Playlist): Observable<Playlist> {
    return this.HttpservicePlaylist.post(this.target, p_chan).pipe(
      map((param_response: any) => {
        return param_response as Playlist;
      })
    );
  }

  public editChan(p_id: number, p_chan: Playlist): Observable<Playlist> {
    return this.HttpservicePlaylist.put(this.target + p_id, p_chan).pipe(
      map((param_response: any) => {
        return param_response as Playlist;
      })
    );
  }

  public deleteChan(p_id: number): Observable<boolean> {
    return this.HttpservicePlaylist.delete(this.target + p_id).pipe(
      map((param_response: any) => {
        return param_response as boolean;
      })
    );
  }
}
