import { Component, OnInit } from '@angular/core';
import { MusicService } from '../music.service';
import { Playlist } from '../playlist';

@Component({
  selector: 'app-playlist',
  templateUrl: './playlist.component.html',
  styleUrls: ['./playlist.component.css']
})
export class PlaylistComponent implements OnInit {
  public musicService:MusicService;
  public play: Playlist[];
  public PlayById: Playlist;
  public newPlay;
  public updatePlay;

  constructor(param_service:MusicService) { 
    this.musicService = param_service;
    this.play = [];
    this.newPlay = {name:"", artist:"",album:"", img:""};
    this.PlayById = {id:null ,name:"", artist:"",album:"", img:""};
    this.updatePlay = {name:"", artist:"",album:"", img:""};
  }

  public create():void{
    if(this.newPlay.name == "" ||
    this.newPlay.artist == "" ||
    this.newPlay.album == "" ||
    this.newPlay.img == ""){
      alert("Merci de remplir tout les champs");
    }else{
      this.musicService.addPlay(this.newPlay).subscribe(
        (data:Playlist) => {
          this.ngOnInit();
        }
      )
    }
  }
  public delete(p_play:Playlist):void{
    this.musicService.deletePlay(p_play.id).subscribe(
      (PlayById:any) => {
        this.ngOnInit();
      }
    )
  }
   public getUpdate(p_id):void{
     this.musicService.getPLayById(p_id).subscribe(
       (PlayById:Playlist)=>{
         this.PlayById = PlayById;
       }
     )
   }

   public putUpdate(p_play:Playlist, p_id):void{
     this.musicService.editPlay(p_id, p_play).subscribe(
       (data:Playlist) => {
         this.ngOnInit();
         this.updatePlay = {name:"", artist:"",album:"", img:""};
       }
     )

   }

  ngOnInit():void {
    this.musicService.getPlayContenu().subscribe(
      (param_play:Playlist[]) =>{
        this.play = param_play;
      }
    )
  }

}
