import {defineStore} from "pinia";

/* 使用 选项式 ts语法 */
/*const useStoreId2Store = defineStore('storeId2', {
    state: () => {
        return {
            userList: [] as UserInfo[],
            user: null as UserInfo | null,
        }
    }
});*/

const useStoreId2Store = defineStore('storeId2', {
    state: (): State => {
        return {
            userList: [],
            user: null
        }
    }
});

interface UserInfo {
    name: string,
    age: number
}

interface State {
    userList: UserInfo[],
    user: UserInfo | null
}

export default useStoreId2Store
