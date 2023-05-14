// localStorage恢复到内存

import {useUserStore} from "/@/store";
import {USER_ID, USER_NAME, USER_TOKEN, ADMIN_USER_ID, ADMIN_USER_NAME, ADMIN_USER_TOKEN} from "/@/store/constants";

export default function Initializer () {
  const userStore = useUserStore()
  userStore.$patch((state)=>{
    state.user_id = localStorage.getItem(USER_ID)
    state.user_name = localStorage.getItem(USER_NAME)
    state.user_token = localStorage.getItem(USER_TOKEN)

    state.admin_user_id = localStorage.getItem(ADMIN_USER_ID)
    state.admin_user_name = localStorage.getItem(ADMIN_USER_NAME)
    state.admin_user_token = localStorage.getItem(ADMIN_USER_TOKEN)
    console.log('恢复store完毕==>', state)
  })

}
