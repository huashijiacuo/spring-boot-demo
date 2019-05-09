## spring-boot 用例

### 整合tk.mybatis
測試用例：TkUserMapper，需要繼承Mapper<T>,類上不加注解@org.apache.ibatis.annotations.Mapper,會出現找不到該bean的情況，可能與mybatis-srping包的衝突？  
使用tk.mybatis包之後，可以直接使用Example相關的方法進行數據庫查詢操作，簡單的查詢語句不需要在xml裏寫SQL語句了。