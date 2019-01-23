import { Component, OnInit } from '@angular/core';
import { ChansonService } from '../service/chanson.service';
import { Chanson } from '../entites/chanson';

@Component({
  selector: 'app-liste',
  templateUrl: './liste.component.html',
  styleUrls: ['./liste.component.scss']
})
export class ListeComponent implements OnInit {

  private service: ChansonService;
  private chansons: Chanson[];
  private name: string;
  private img: string;
  private artist: string;
  private album: string;
  private changeName: boolean;
  private changeArtist: boolean;
  private changeAlbum: boolean;
  private changeImg: boolean;

  constructor(param: ChansonService) {
    this.service = param;
    this.changeName = false;
    this.changeArtist = false;
    this.changeAlbum = false;
    this.changeImg = false;
  }

  ngOnInit() {
    this.getAllChansons();
  }

  public getAllChansons() {
    this.service.getAll().subscribe(
      (data: Chanson[]) => {
        this.chansons = data;
      }
    );
  }

  public addChanson(event) {
    event.preventDefault();
    const chanson: Chanson = new Chanson();

    chanson.album = this.album;
    chanson.artist = this.artist;
    chanson.img = this.img;
    chanson.name = this.name;

    this.service.add(chanson).subscribe(
      (data: any) => {
        this.getAllChansons();
      }
    );
  }

  public deleteChanson(id: number) {
    this.service.delete(id).subscribe(
      (data: any) => {
        this.getAllChansons();
      }
    );
  }

  public setName(id: number, change: boolean) {
    this.changeName = change;
    const newName: string = (<HTMLInputElement>document.getElementById('name' + id)).value;

    if (change === false) {
      this.service.getById(id).subscribe(
        (data: Chanson) => {
          data.name = newName;
          this.service.update(id, data).subscribe(
            (dat: any) => {
              this.getAllChansons();
            }
          );
        }
      );
    }
  }

  public setArtist(id: number, change: boolean) {
    this.changeArtist = change;
    const newArtist: string = (<HTMLInputElement>document.getElementById('artist' + id)).value;

    if (change === false) {
      this.service.getById(id).subscribe(
        (data: Chanson) => {
          data.artist = newArtist;
          this.service.update(id, data).subscribe(
            (dat: any) => {
              this.getAllChansons();
            }
          );
        }
      );
    }
  }

  public setAlbum(id: number, change: boolean) {
    this.changeAlbum = change;
    const newAlbum: string = (<HTMLInputElement>document.getElementById('album' + id)).value;

    if (change === false) {
      this.service.getById(id).subscribe(
        (data: Chanson) => {
          data.album = newAlbum;
          this.service.update(id, data).subscribe(
            (dat: any) => {
              this.getAllChansons();
            }
          );
        }
      );
    }
  }

  public setImg(id: number, change: boolean) {
    this.changeImg = change;

    const newImg: string = (<HTMLInputElement>document.getElementById('img' + id)).value;

    if (change === false) {
      this.service.getById(id).subscribe(
        (data: Chanson) => {
          data.img = newImg;
          this.service.update(id, data).subscribe(
            (dat: any) => {
              this.getAllChansons();
            }
          );
        }
      );
    }
  }
}
