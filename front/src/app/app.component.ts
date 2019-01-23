import { Component, OnInit } from '@angular/core';
import { Songs } from './songs';
import { SongService } from './song.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'songList';

  public songs: Songs[];

  public song: Songs;

  private _serv: SongService;

  constructor(param_serv: SongService) {
    this._serv = param_serv;
    this.song = new Songs();
  }

  // Refresh
  public refresh() {
    this.song = new Songs();
    this.listAllSongs();
  }

  // Get all massages
  public listAllSongs() {
    this._serv.getSongs().subscribe(
      (data: any) => {
        this.songs = data;
      }
    );
  }

  // Add a massage
  public onAdd() {
    this._serv.createSong(this.song).subscribe(
      () => {
        this.refresh();
        alert('La chanson a été ajouté avec succès !');
      }
    );

  }

  // Delete a massage with its id
  public onDelete(id: number) {
    // Ask for a confirmation
    const confirmation = confirm('Voulez-vous vraiment supprimer cette chanson ?');
    if (confirmation) {
      this._serv.deleteSong(id).subscribe(
        () => {
          this.refresh();
          alert('La chanson a été supprimé avec succès !');
        }
      );

    }
  }

  // Update a message
  // First, get the massage with its id
  public onModify(id: number) {
    this._serv.getSong(id).subscribe(
      (data: any) => {
        this.song = data;
      }
    );
  }

  // Then, put the massage with its id
  public onUpdate() {
    this._serv.updateSong(this.song.id, this.song).subscribe(
      () => {
        this.refresh();
        alert('La chanson a été modifié avec succès !');
      }
    );

  }


  ngOnInit() {

    this.listAllSongs();
  }


}
