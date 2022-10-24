import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutModComponent } from './components/about/about-mod.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'about-mod/:id', component: AboutModComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
