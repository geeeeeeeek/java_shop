export type RoleType = '' | '*' | 'admin' | 'user';
export interface UserState {
  user_id: any;
  user_name: any;
  user_token: any;

  admin_user_id: any;
  admin_user_name: any;
  admin_user_token: any;
}
