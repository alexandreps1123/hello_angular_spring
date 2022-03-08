import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { NamesRoutingModule } from './names-routing.module';
import { NamesComponent } from './names/names.component';



@NgModule({
  declarations: [
    NamesComponent
  ],
  imports: [
    CommonModule,
    AppMaterialModule,
    NamesRoutingModule
  ]
})
export class NamesModule { }
