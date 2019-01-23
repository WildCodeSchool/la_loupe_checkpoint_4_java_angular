import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SongComponent } from './components/song/song.component';
import { CreateSongComponent } from './components/create-song/create-song.component';
import { ShowSongComponent } from './components/show-song/show-song.component';

const routes: Routes = [
  {path: '', redirectTo: '/song', pathMatch: 'full'},
  {path: 'song', component: SongComponent, pathMatch: 'full'},
  {path: 'create', component: CreateSongComponent, pathMatch: 'full'},
  {path: 'show', component: ShowSongComponent, pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
