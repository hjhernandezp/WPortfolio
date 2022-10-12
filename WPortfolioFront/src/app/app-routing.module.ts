import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CursosAddComponent } from './components/cursos/cursos-add.component';
import { CursosModComponent } from './components/cursos/cursos-mod.component';
import { EstudiosAddComponent } from './components/estudios/estudios-add.component';
import { EstudiosModComponent } from './components/estudios/estudios-mod.component';
import { ExperienciaAddComponent } from './components/experiencia/experiencia-add.component';
import { ExperienciaModComponent } from './components/experiencia/experiencia-mod.component';
import { HabilidadesAddComponent } from './components/habilidades/habilidades-add.component';
import { HabilidadesModComponent } from './components/habilidades/habilidades-mod.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'estudios-add', component: EstudiosAddComponent },
  { path: 'estudios-mod/:id', component: EstudiosModComponent },
  { path: 'experiencia-add', component: ExperienciaAddComponent },
  { path: 'experiencia-mod/:id', component: ExperienciaModComponent },
  { path: 'cursos-add', component: CursosAddComponent },
  { path: 'cursos-mod/:id', component: CursosModComponent },
  { path: 'habilidades-add', component: HabilidadesAddComponent},
  { path: 'habilidades-mod/:id', component: HabilidadesModComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
