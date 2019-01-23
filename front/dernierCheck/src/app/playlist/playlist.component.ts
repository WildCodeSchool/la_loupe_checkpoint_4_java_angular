import { Component, OnInit } from '@angular/core';
import { Playlist } from '../playlist';
import { PlaylistService } from '../playlist.service';

@Component({
  selector: 'app-playlist',
  templateUrl: './playlist.component.html',
  styleUrls: ['./playlist.component.css']
})
export class PlaylistComponent implements OnInit {

  public playById: Playlist;
  public updatePlaylist;
  private playlistService: PlaylistService;
  public newPlayList: Playlist[];
  public newPlay : Playlist;
  public Id: number;

  constructor(param_service_playlist:PlaylistService) {
    this.playById = {url:"", name:"", artist:"", album:"", id: null };
    this.updatePlaylist = {url:"", name:"", artist:"", album:""};
    this.playlistService = param_service_playlist;
    this.newPlayList = [];
    this.newPlay = {url:"", name:"", artist:"", album:""};
    this.Id = 0;
   }

  public ngOnInit():void {
    this.playlistService.getPlaylist().subscribe((result:Playlist[])=>{
      this.newPlayList = result;
    });
  }

  public id(current_id):void {
    this.Id = current_id.id;
  }

  public create():void{
    if (this.newPlay.name == "" || this.newPlay.artist == "" || this.newPlay.album == ""){
      alert("Attention, tous les champs ne sont pas remplis !");
    }
    else {
      this.playlistService.addPlaylist(this.newPlay).subscribe((data: Playlist)=>{
        this.ngOnInit();
      });
    }
  }

  public getUpdate(p_id):void{
    this.playlistService.getById(p_id).subscribe((playById: Playlist)=>{
      this.playById = playById;
    });
  }

  public putUpdate(p_new: Playlist, p_id):void{
    this.playlistService.editPlaylist(p_new, p_id).subscribe((data: Playlist)=>{
      console.log(p_new);
        this.ngOnInit();
        this.updatePlaylist = {url:"", name:"", artist:"", album:""};
        this.newPlay.url = "";
      });
  }

  public delete(p_new): void{
    this.playlistService.deletePlaylist(p_new).subscribe((data: any)=>{
      this.ngOnInit();
      this.Id = 0;
    });
  }
}

