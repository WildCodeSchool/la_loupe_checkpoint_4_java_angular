import { Component } from '@angular/core';
import { SongServiceService } from './song-service.service';
import { Song } from './song';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  public service: SongServiceService;
  public songToModify: Song;
  public songlist: Song[];
  public IdToDelete;
  public IdToModif;
  public tmpSong = new Song;
  public modifSong = new Song;

  constructor(service: SongServiceService) {
    this.service = service;
  }

  ngOnInit() {
    this.service.getAllSongs().subscribe(
      (param) => {
        this.songlist = param;
        console.log(this.songlist);
      }
    )
    
  }

  public updateSong() {
    this.service.updateSongFromDB(this.IdToModif, this.modifSong).subscribe();
    // console.log(this.modifSong);
    alert(`La chanson ${this.IdToModif} a bien été mise à jour.`);
    location.reload();
  }

  public deleteSong() {
    this.service.deleteSongFromDB(this.IdToDelete).subscribe();
    alert(`La chanson ${this.IdToDelete} a bien été supprimé.`);
    location.reload();
  }

  public addSong(): void {
    this.service.addSong(this.tmpSong).subscribe();
    this.tmpSong = new Song();
    alert(`La chanson a bien été soumise`);
    location.reload();
  }

}
