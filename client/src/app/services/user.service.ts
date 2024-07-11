import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private userRole: string = 'customer';

  getUserRole(): string {
    return this.userRole;
  }

  isAdmin(): boolean {
    return this.userRole === 'admin';
  }

  setUserRole(role: string) {
    this.userRole = role;
  }

  validatePassword(password: string): boolean {
    return password === '1234';
  }
}
