// 权限问题后期增加
import { get, post } from '/@/utils/http/axios';
import { UserState } from '/@/store/modules/user/types';
// import axios from 'axios';
enum URL {
    login = '/api/user/login',
    userList = '/api/user/list',
    detail = '/api/user/detail',
    create = '/api/user/create',
    update = '/api/user/update',
    delete = '/api/user/delete',
    userLogin = '/api/user/userLogin',
    userRegister = '/api/user/userRegister',
    updateUserPwd = '/api/user/updatePwd',
}
interface LoginRes {
    token: string;
}

export interface LoginData {
    username: string;
    password: string;
}

const loginApi = async (data: LoginData) => post<any>({ url: URL.login, data, headers: { 'Content-Type': 'multipart/form-data;charset=utf-8' } });
const listApi = async (params: any) => get<any>({ url: URL.userList, params: params, data: {}, headers: {} });
const detailApi = async (params: any) => get<any>({ url: URL.detail, params: params, data: {}, headers: {} });
const createApi = async (data: any) => post<any>({ url: URL.create, params: {}, data: data, headers: { 'Content-Type': 'multipart/form-data;charset=utf-8' } });
const updateApi = async (data: any) => post<any>({ url: URL.update, data: data, headers: { 'Content-Type': 'multipart/form-data;charset=utf-8' } });
const deleteApi = async (params: any) => post<any>({ url: URL.delete, params: params, headers: {} });
const userLoginApi = async (data: LoginData) => post<any>({ url: URL.userLogin, data, headers: { 'Content-Type': 'multipart/form-data;charset=utf-8' } });
const userRegisterApi = async (data: any) => post<any>({ url: URL.userRegister, params: {}, data: data, headers: { 'Content-Type': 'multipart/form-data;charset=utf-8' } });
const updateUserPwdApi = async (params: any) => post<any>({ url: URL.updateUserPwd, params: params });

export { loginApi, listApi, detailApi, createApi, updateApi, deleteApi, userLoginApi, userRegisterApi, updateUserPwdApi};
