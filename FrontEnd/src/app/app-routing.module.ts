import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {DashboardComponent} from "./views/dashboard/dashboard.component";
import {ManageCustomersComponent} from "./views/manage-customers/manage-customers.component";
import {ManageCustomerComponentCandeactivateGuard} from "./guards/manage-customer-component-candeactivate.guard";
import {MainComponent} from "./views/main/main.component";
import {LoginComponent} from "./views/login/login.component";
import {AuthGuard} from "./guards/auth.guard";
import {ItemsComponent} from "./views/items/items.component";
import {ManageItemComponentCandeactivateGuardGuard} from "./guards/manage-item-component-candeactivate-guard.guard";
import {PlaceOrderComponent} from "./views/place-order/place-order.component";
import {ViewOrdersComponent} from "./views/view-orders/view-orders.component";

const appRoutes: Routes = [
  {
    path: "main",
    component: MainComponent,
    canActivate: [AuthGuard],
    children: [
      {path: "dashboard", component: DashboardComponent},
      {
        path: "manage-customers",
        component: ManageCustomersComponent,
        canDeactivate: [ManageCustomerComponentCandeactivateGuard]
      },
      {
        path: "manage-items",
        component: ItemsComponent,
        canDeactivate: [ManageItemComponentCandeactivateGuardGuard]
      },
      {
        path: "place-order",
        component: PlaceOrderComponent
      },
      {
        path: "view-order",
        component: ViewOrdersComponent
      },

      {
        path: "",
        pathMatch : "full",
        redirectTo: "/main/dashboard"
      }
    ]
  },
  {path: "login", component: LoginComponent},
  {path: "", pathMatch: "full", redirectTo: "/main/dashboard"}
]

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {
}
