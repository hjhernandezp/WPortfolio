import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { BannerComponent } from './components/banner/banner.component';
import { AboutComponent } from './components/about/about.component';
import { TabsComponent } from './components/tabs/tabs.component';
import { PanelComponent } from './components/panel/panel.component';
import { NgCircleProgressModule } from 'ng-circle-progress';
import { FooterComponent } from './components/footer/footer.component';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { interceptorProvider } from './services/interceptor-service';
import { EstudiosComponent } from './components/estudios/estudios.component';
import { EstudiosAddComponent } from './components/estudios/estudios-add.component';
import { EstudiosModComponent } from './components/estudios/estudios-mod.component';
import { ExperienciaComponent } from './components/experiencia/experiencia.component';
import { ExperienciaAddComponent } from './components/experiencia/experiencia-add.component';
import { ExperienciaModComponent } from './components/experiencia/experiencia-mod.component';
import { CursosComponent } from './components/cursos/cursos.component';
import { CursosAddComponent } from './components/cursos/cursos-add.component';
import { CursosModComponent } from './components/cursos/cursos-mod.component';
import { HabilidadesComponent } from './components/habilidades/habilidades.component';
import { HabilidadesAddComponent } from './components/habilidades/habilidades-add.component';
import { HabilidadesModComponent } from './components/habilidades/habilidades-mod.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    BannerComponent,
    AboutComponent,
    TabsComponent,
    PanelComponent,
    FooterComponent,
    HomeComponent,
    LoginComponent,
    EstudiosComponent,
    EstudiosAddComponent,
    EstudiosModComponent, 
    ExperienciaComponent,
    ExperienciaAddComponent,
    ExperienciaModComponent,
    CursosComponent,
    CursosAddComponent,
    CursosModComponent,
    HabilidadesComponent,
    HabilidadesAddComponent,
    HabilidadesModComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    NgCircleProgressModule.forRoot({}),
    HttpClientModule
  ],
  providers: [
    interceptorProvider
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
