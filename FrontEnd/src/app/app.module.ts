import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { DashboardComponent } from './views/dashboard/dashboard.component';
import { ManageCustomersComponent } from './views/manage-customers/manage-customers.component';
import {RouterModule, Routes} from "@angular/router";
import {CustomerService} from "./services/customer.service";
import {HttpClientModule} from "@angular/common/http";
import {NgxPaginationModule} from "ngx-pagination";
import {FormsModule} from "@angular/forms";
import {ManageCustomerComponentCandeactivateGuard} from "./guards/manage-customer-component-candeactivate.guard";
import { LoginComponent } from './views/login/login.component';
import { MainComponent } from './views/main/main.component';
import {AppRoutingModule} from "./app-routing.module";
import {AuthGuard} from "./guards/auth.guard";
import {AuthService} from "./services/auth.service";
import { ItemsComponent } from './views/items/items.component';
import {ItemService} from "./services/item.service";
import { PlaceOrderComponent } from './views/place-order/place-order.component';
import {ManageItemComponentCandeactivateGuardGuard} from "./guards/manage-item-component-candeactivate-guard.guard";
import {PlaceOrder} from "./dtos/place-order";
import {PlaceOrderServiceService} from "./services/place-order-service.service";
import { ViewOrdersComponent } from './views/view-orders/view-orders.component';



@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    ManageCustomersComponent,
    LoginComponent,
    MainComponent,
    ItemsComponent,
    PlaceOrderComponent,
    ViewOrdersComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    NgxPaginationModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [
    CustomerService,
    ItemService,
    PlaceOrderServiceService,
    ManageCustomerComponentCandeactivateGuard,
    ManageItemComponentCandeactivateGuardGuard,
    AuthGuard,
    AuthService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
