import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-song-list',
  templateUrl: './song-list.component.html',
  styleUrls: ['./song-list.component.css']
})
export class SongListComponent implements OnInit {
   private api:ApiService;
   private songs = [];

   private songToAdd = {
      name:"",
      artist:"",
      album:"",
      img:""
   }

  constructor(service:ApiService) {
     this.api = service
 }

  ngOnInit() {
     this.api.apiGet("/songs").subscribe(
        (incoming) => {
           this.songs = incoming;
           console.log(this.songs);
        }
     )
  }

  deleteSong(id) {
     this.api.apiDelete("/songs/" + id).subscribe(
       (incoming) => {
          this.ngOnInit()
       }
     )
 }

 addSong() {
    this.api.apiPost("/songs", this.songToAdd).subscribe(
      (incoming) => {
          this.ngOnInit()
          this.songToAdd = {
             name:"",
             artist:"",
             album:"",
             img:""
          }
      }
    )
}

}
