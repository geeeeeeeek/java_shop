import {get, post} from '/@/utils/http/axios';

enum URL {
    userList = '/api/ad/list',
    create = '/api/ad/create',
    update = '/api/ad/update',
    delete = '/api/ad/delete',
}

const listApi = async (params: any) =>
    get<any>({url: URL.userList, params: params, data: {}, headers: {}});
const createApi = async (data: any) =>
    post<any>({
        url: URL.create,
        params: {},
        data: data,
        headers: {'Content-Type': 'multipart/form-data;charset=utf-8'}
    });
const updateApi = async (data: any) =>
    post<any>({
        url: URL.update,
        data: data,
        headers: {'Content-Type': 'multipart/form-data;charset=utf-8'}
    });
const deleteApi = async (params: any) =>
    post<any>({url: URL.delete, params: params, headers: {}});

export {listApi, createApi, updateApi, deleteApi};
