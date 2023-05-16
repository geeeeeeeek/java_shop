/**
 * @name createVitePlugins
 * @description 封装plugins数组统一调用
 */
import {PluginOption} from 'vite';
import vue from '@vitejs/plugin-vue';
import vueJsx from '@vitejs/plugin-vue-jsx';
import {AutoImportDeps} from './autoImport';
import {ConfigCompressPlugin} from './compress';
import {ConfigRestartPlugin} from './restart';
import {ConfigProgressPlugin} from './progress';
import {ConfigVisualizerConfig} from "./visualizer";

export function createVitePlugins(isBuild: boolean) {
    const vitePlugins = [
        // vue支持
        vue(),
        // JSX支持
        vueJsx(),
        // setup语法糖组件名支持
        // vueSetupExtend(),
        // 提供https证书
        // VitePluginCertificate({
        //   source: 'coding',
        // }) as PluginOption,
    ];

    // 自动按需引入组件
    // vitePlugins.push(AutoRegistryComponents());

    // 自动按需引入依赖
    vitePlugins.push(AutoImportDeps());

    // 自动生成路由
    // vitePlugins.push(ConfigPagesPlugin());

    // 开启.gz压缩  rollup-plugin-gzip
    vitePlugins.push(ConfigCompressPlugin());

    // 监听配置文件改动重启
    vitePlugins.push(ConfigRestartPlugin());

    // 构建时显示进度条
    vitePlugins.push(ConfigProgressPlugin());

    // 构建时显示进度条
    vitePlugins.push(ConfigVisualizerConfig());


    return vitePlugins;
}
