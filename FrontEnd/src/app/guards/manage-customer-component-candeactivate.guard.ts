import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, CanDeactivate} from '@angular/router';
import { Observable } from 'rxjs';
import {ManageCustomersComponent} from "../views/manage-customers/manage-customers.component";

@Injectable()
export class ManageCustomerComponentCandeactivateGuard implements CanDeactivate<ManageCustomersComponent> {

  canDeactivate(component: ManageCustomersComponent, currentRoute: ActivatedRouteSnapshot, currentState: RouterStateSnapshot, nextState?: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if (component.frmCustomers.dirty){
      return confirm("Are you sure you want to discard your changes?");
    }
    return true;
  }

}
