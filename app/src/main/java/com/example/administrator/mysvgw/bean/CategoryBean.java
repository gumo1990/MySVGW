package com.example.administrator.mysvgw.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by whq on 2018/1/4.
 */

public class CategoryBean implements Serializable {

        /**
         * cateName : 美容护肤
         * cateImg : http://www.svgouwu.com//data/cate_image/15087242611840.jpg
         * cateId : 2581
         * cateImage : icon-meirong
         * classify_rank : 1
         * brand : [{"brandName":"劲霸","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/21.jpg"},{"brandName":"美人谷","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/23.jpg"},{"brandName":"薇姿","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/24.jpg"},{"brandName":"高姿","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/25.jpg"},{"brandName":"兰芝","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/26.jpg"},{"brandName":"碧欧泉","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/27.jpg"},{"brandName":"欧莱雅","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/28.jpg"},{"brandName":"悦诗风吟","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/29.jpg"},{"brandName":"九朵云","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/30.jpg"},{"brandName":"香奈儿","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/31.jpg"},{"brandName":"YSL 圣罗兰","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/32.jpg"},{"brandName":"雅诗兰黛","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/48.jpg"},{"brandName":"植美村","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/50.jpg"},{"brandName":"水密码","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/51.jpg"},{"brandName":"丹姿","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/52.jpg"},{"brandName":"森田药妆","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/56.jpg"},{"brandName":"比芭美","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/57.jpg"},{"brandName":"曼秀雷敦","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/62.jpg"},{"brandName":"理肤泉","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/63.jpg"},{"brandName":"玉兰油","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/64.jpg"},{"brandName":"美迪惠尔","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/65.jpg"},{"brandName":"瑾泉","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/71.jpg"},{"brandName":"资生堂","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/72.jpg"},{"brandName":"娇韵诗","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/74.jpg"},{"brandName":"高丝/KOSE","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/75.jpg"},{"brandName":"倩碧/Clinique","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/76.jpg"},{"brandName":"博姿/Boots","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/77.jpg"},{"brandName":"迪奥/Dior","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/79.jpg"},{"brandName":"大创/DAISO","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/80.jpg"},{"brandName":"贵妇/DIA FORCE","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/81.jpg"},{"brandName":"春雨","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/82.jpg"},{"brandName":"贝德玛/Bioderma","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/85.jpg"},{"brandName":"袋鼠/Aussie","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/86.jpg"},{"brandName":"凡士林/Vaseline","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/87.jpg"},{"brandName":"碧柔/Biore","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/89.jpg"},{"brandName":"雅漾 Avene","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/90.jpg"},{"brandName":"VIVLAS/唯兰颂","brandLogo":"http://www.svgouwu.com/"},{"brandName":"雪花秀/Sulwhasoo","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/93.jpg"},{"brandName":"Freeplus/芙丽芳丝","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/95.jpg"},{"brandName":"妮维雅/NIVEA","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/98.jpg"},{"brandName":"卡姿兰","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/99.jpg"},{"brandName":"娇兰","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/100.jpg"},{"brandName":"SK-II","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/103.jpg"},{"brandName":"美丽妮","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/105.jpg"},{"brandName":"百雀羚","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/107.jpg"},{"brandName":"韩束","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/109.jpg"},{"brandName":"一叶子","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/110.jpg"},{"brandName":"索薇娅","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/111.jpg"},{"brandName":"赫拉","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/112.jpg"},{"brandName":"伊思","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/113.jpg"},{"brandName":"AHC","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/114.jpg"},{"brandName":"SNP","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/115.jpg"},{"brandName":"兰蔻","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/116.jpg"},{"brandName":"科颜氏","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/117.jpg"},{"brandName":"JAYJUN","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/118.jpg"},{"brandName":"MG美即","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/119.jpg"},{"brandName":"依云","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/120.jpg"},{"brandName":"菲奥娜","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/122.jpg"},{"brandName":"博朗","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/132.jpg"},{"brandName":"力博得","brandLogo":"http://www.svgouwu.com/data/files/mall/brand/134.jpg"}]
         * children : [{"cateName":"身体护理","cateImg":"http://www.svgouwu.com//data/cate_image/15034666366325.jpg","cateId":2582,"cateImage":"","classify_rank":2,"children":[{"cateName":"精油","cateImg":null,"cateId":2583,"cateImage":"","classify_rank":3},{"cateName":"纤体","cateImg":null,"cateId":2584,"cateImage":"","classify_rank":3},{"cateName":"套装","cateImg":null,"cateId":2585,"cateImage":"","classify_rank":3},{"cateName":"润肤","cateImg":null,"cateId":2586,"cateImage":"","classify_rank":3},{"cateName":"手足","cateImg":null,"cateId":2587,"cateImage":"","classify_rank":3},{"cateName":"美胸","cateImg":null,"cateId":2588,"cateImage":"","classify_rank":3},{"cateName":"颈部","cateImg":null,"cateId":2589,"cateImage":"","classify_rank":3},{"cateName":"塑形","cateImg":null,"cateId":2591,"cateImage":"","classify_rank":3},{"cateName":"造型","cateImg":null,"cateId":2594,"cateImage":"","classify_rank":3},{"cateName":"染发","cateImg":null,"cateId":2597,"cateImage":"","classify_rank":3},{"cateName":"美发","cateImg":null,"cateId":2598,"cateImage":"","classify_rank":3},{"cateName":"假发","cateImg":null,"cateId":2600,"cateImage":"","classify_rank":3},{"cateName":"私密护理","cateImg":null,"cateId":2640,"cateImage":"","classify_rank":3},{"cateName":"卫生巾","cateImg":null,"cateId":2641,"cateImage":"","classify_rank":3},{"cateName":"卫生护垫","cateImg":null,"cateId":2642,"cateImage":"","classify_rank":3},{"cateName":"脱毛膏","cateImg":null,"cateId":2643,"cateImage":"","classify_rank":3}]},{"cateName":"面部护肤","cateImg":"http://www.svgouwu.com//data/cate_image/15034666525823.jpg","cateId":2601,"cateImage":"","classify_rank":2,"children":[{"cateName":"眼霜","cateImg":null,"cateId":2602,"cateImage":"","classify_rank":3},{"cateName":"面霜","cateImg":null,"cateId":2603,"cateImage":"","classify_rank":3},{"cateName":"爽肤水","cateImg":null,"cateId":2604,"cateImage":"","classify_rank":3},{"cateName":"面膜","cateImg":null,"cateId":2605,"cateImage":"","classify_rank":3},{"cateName":"卸妆","cateImg":null,"cateId":2606,"cateImage":"","classify_rank":3},{"cateName":"乳液","cateImg":null,"cateId":2607,"cateImage":"","classify_rank":3},{"cateName":"洁面","cateImg":null,"cateId":2608,"cateImage":"","classify_rank":3},{"cateName":"套装","cateImg":null,"cateId":2609,"cateImage":"","classify_rank":3},{"cateName":"精华","cateImg":null,"cateId":2610,"cateImage":"","classify_rank":3},{"cateName":"防晒","cateImg":null,"cateId":2611,"cateImage":"","classify_rank":3}]},{"cateName":"香水彩妆","cateImg":"http://www.svgouwu.com//data/cate_image/15034667134117.jpg","cateId":2613,"cateImage":"","classify_rank":2,"children":[{"cateName":"睫毛膏","cateImg":null,"cateId":2614,"cateImage":"","classify_rank":3},{"cateName":"套装","cateImg":null,"cateId":2615,"cateImage":"","classify_rank":3},{"cateName":"唇膏/彩","cateImg":null,"cateId":2616,"cateImage":"","classify_rank":3},{"cateName":"底妆","cateImg":null,"cateId":2618,"cateImage":"","classify_rank":3},{"cateName":"眉笔","cateImg":null,"cateId":2619,"cateImage":"","classify_rank":3},{"cateName":"美甲","cateImg":null,"cateId":2620,"cateImage":"","classify_rank":3},{"cateName":"眼影","cateImg":null,"cateId":2621,"cateImage":"","classify_rank":3},{"cateName":"男士香水","cateImg":null,"cateId":2622,"cateImage":"","classify_rank":3},{"cateName":"眼线","cateImg":null,"cateId":2623,"cateImage":"","classify_rank":3},{"cateName":"腮红","cateImg":null,"cateId":2624,"cateImage":"","classify_rank":3},{"cateName":"女士香水","cateImg":null,"cateId":2625,"cateImage":"","classify_rank":3}]},{"cateName":"口腔清洁","cateImg":"http://www.svgouwu.com//data/cate_image/15034667343609.jpg","cateId":3667,"cateImage":"","classify_rank":2,"children":[{"cateName":"墨盒","cateImg":null,"cateId":2249,"cateImage":"","classify_rank":3},{"cateName":"套装","cateImg":null,"cateId":2627,"cateImage":"","classify_rank":3},{"cateName":"牙膏/牙粉","cateImg":null,"cateId":2628,"cateImage":"","classify_rank":3},{"cateName":"漱口水","cateImg":null,"cateId":2629,"cateImage":"","classify_rank":3},{"cateName":"牙刷/牙线","cateImg":null,"cateId":2630,"cateImage":"","classify_rank":3}]},{"cateName":"美妆工具","cateImg":"http://www.svgouwu.com//data/cate_image/15034667481120.jpg","cateId":3712,"cateImage":"","classify_rank":2,"children":[{"cateName":"理发器","cateImg":null,"cateId":2147,"cateImage":"","classify_rank":3},{"cateName":"按摩器","cateImg":null,"cateId":2439,"cateImage":"","classify_rank":3},{"cateName":"剃须刀","cateImg":null,"cateId":2440,"cateImage":"","classify_rank":3},{"cateName":"美容器","cateImg":null,"cateId":2442,"cateImage":"","classify_rank":3},{"cateName":"电吹风","cateImg":null,"cateId":2445,"cateImage":"","classify_rank":3},{"cateName":"剃/脱毛器","cateImg":null,"cateId":2447,"cateImage":"","classify_rank":3},{"cateName":"卷/直发器","cateImg":null,"cateId":2451,"cateImage":"","classify_rank":3},{"cateName":"工具","cateImg":null,"cateId":2596,"cateImage":"","classify_rank":3},{"cateName":"剃须刀","cateImg":null,"cateId":2612,"cateImage":"","classify_rank":3},{"cateName":"美妆工具","cateImg":null,"cateId":2617,"cateImage":"","classify_rank":3}]}]
         */

        private String cateName;
        private String cateImg;
        private int cateId;
        private String cateImage;
        private int classify_rank;
        private List<BrandBean> brand;
        private List<ChildrenBeanX> children;

        public String getCateName() {
            return cateName;
        }

        public void setCateName(String cateName) {
            this.cateName = cateName;
        }

        public String getCateImg() {
            return cateImg;
        }

        public void setCateImg(String cateImg) {
            this.cateImg = cateImg;
        }

        public int getCateId() {
            return cateId;
        }

        public void setCateId(int cateId) {
            this.cateId = cateId;
        }

        public String getCateImage() {
            return cateImage;
        }

        public void setCateImage(String cateImage) {
            this.cateImage = cateImage;
        }

        public int getClassify_rank() {
            return classify_rank;
        }

        public void setClassify_rank(int classify_rank) {
            this.classify_rank = classify_rank;
        }

        public List<BrandBean> getBrand() {
            return brand;
        }

        public void setBrand(List<BrandBean> brand) {
            this.brand = brand;
        }

        public List<ChildrenBeanX> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBeanX> children) {
            this.children = children;
        }

        public static class BrandBean {
            /**
             * brandName : 劲霸
             * brandLogo : http://www.svgouwu.com/data/files/mall/brand/21.jpg
             */

            private String brandName;
            private String brandLogo;

            public String getBrandName() {
                return brandName;
            }

            public void setBrandName(String brandName) {
                this.brandName = brandName;
            }

            public String getBrandLogo() {
                return brandLogo;
            }

            public void setBrandLogo(String brandLogo) {
                this.brandLogo = brandLogo;
            }
        }

        public static class ChildrenBeanX {
            /**
             * cateName : 身体护理
             * cateImg : http://www.svgouwu.com//data/cate_image/15034666366325.jpg
             * cateId : 2582
             * cateImage :
             * classify_rank : 2
             * children : [{"cateName":"精油","cateImg":null,"cateId":2583,"cateImage":"","classify_rank":3},{"cateName":"纤体","cateImg":null,"cateId":2584,"cateImage":"","classify_rank":3},{"cateName":"套装","cateImg":null,"cateId":2585,"cateImage":"","classify_rank":3},{"cateName":"润肤","cateImg":null,"cateId":2586,"cateImage":"","classify_rank":3},{"cateName":"手足","cateImg":null,"cateId":2587,"cateImage":"","classify_rank":3},{"cateName":"美胸","cateImg":null,"cateId":2588,"cateImage":"","classify_rank":3},{"cateName":"颈部","cateImg":null,"cateId":2589,"cateImage":"","classify_rank":3},{"cateName":"塑形","cateImg":null,"cateId":2591,"cateImage":"","classify_rank":3},{"cateName":"造型","cateImg":null,"cateId":2594,"cateImage":"","classify_rank":3},{"cateName":"染发","cateImg":null,"cateId":2597,"cateImage":"","classify_rank":3},{"cateName":"美发","cateImg":null,"cateId":2598,"cateImage":"","classify_rank":3},{"cateName":"假发","cateImg":null,"cateId":2600,"cateImage":"","classify_rank":3},{"cateName":"私密护理","cateImg":null,"cateId":2640,"cateImage":"","classify_rank":3},{"cateName":"卫生巾","cateImg":null,"cateId":2641,"cateImage":"","classify_rank":3},{"cateName":"卫生护垫","cateImg":null,"cateId":2642,"cateImage":"","classify_rank":3},{"cateName":"脱毛膏","cateImg":null,"cateId":2643,"cateImage":"","classify_rank":3}]
             */

            private String cateName;
            private String cateImg;
            private int cateId;
            private String cateImage;
            private int classify_rank;
            private List<ChildrenBean> children;

            public String getCateName() {
                return cateName;
            }

            public void setCateName(String cateName) {
                this.cateName = cateName;
            }

            public String getCateImg() {
                return cateImg;
            }

            public void setCateImg(String cateImg) {
                this.cateImg = cateImg;
            }

            public int getCateId() {
                return cateId;
            }

            public void setCateId(int cateId) {
                this.cateId = cateId;
            }

            public String getCateImage() {
                return cateImage;
            }

            public void setCateImage(String cateImage) {
                this.cateImage = cateImage;
            }

            public int getClassify_rank() {
                return classify_rank;
            }

            public void setClassify_rank(int classify_rank) {
                this.classify_rank = classify_rank;
            }

            public List<ChildrenBean> getChildren() {
                return children;
            }

            public void setChildren(List<ChildrenBean> children) {
                this.children = children;
            }

            public static class ChildrenBean {
                /**
                 * cateName : 精油
                 * cateImg : null
                 * cateId : 2583
                 * cateImage :
                 * classify_rank : 3
                 */

                private String cateName;
                private Object cateImg;
                private int cateId;
                private String cateImage;
                private int classify_rank;

                public String getCateName() {
                    return cateName;
                }

                public void setCateName(String cateName) {
                    this.cateName = cateName;
                }

                public Object getCateImg() {
                    return cateImg;
                }

                public void setCateImg(Object cateImg) {
                    this.cateImg = cateImg;
                }

                public int getCateId() {
                    return cateId;
                }

                public void setCateId(int cateId) {
                    this.cateId = cateId;
                }

                public String getCateImage() {
                    return cateImage;
                }

                public void setCateImage(String cateImage) {
                    this.cateImage = cateImage;
                }

                public int getClassify_rank() {
                    return classify_rank;
                }

                public void setClassify_rank(int classify_rank) {
                    this.classify_rank = classify_rank;
                }
            }
        }
}
