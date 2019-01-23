import { NgModule } from '@angular/core';
import { Routes, RouterModule, ExtraOptions } from '@angular/router';
import { MusicDashboardComponent } from './components/music-dashboard/music-dashboard.component';


const routes: Routes =
  [
    { path: '', component: MusicDashboardComponent, pathMatch: 'full' },

  ];

const routerOptions: ExtraOptions = {
    useHash: true
}

@NgModule({
imports: [RouterModule.forRoot(routes, routerOptions)],
exports: [RouterModule]
})

export class AppRoutingModule { }