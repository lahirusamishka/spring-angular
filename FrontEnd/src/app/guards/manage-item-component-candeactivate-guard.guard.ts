import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, CanDeactivate} from '@angular/router';
import { Observable } from 'rxjs';
import {ItemsComponent} from "../views/items/items.component";

@Injectable()
export class ManageItemComponentCandeactivateGuardGuard implements CanDeactivate<ItemsComponent> {
  canDeactivate(component: ItemsComponent, currentRoute: ActivatedRouteSnapshot, currentState: RouterStateSnapshot, nextState?: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if (component.frmItems.dirty){
      return confirm("Are you sure you want to discard your changes?");
    }
    return true;
  }



}
