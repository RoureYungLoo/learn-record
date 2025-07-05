/* 转换客户数据，写入数据库 */
public class CustomerDAO {
    public void addCustomers(){
        /* 当客户数据是txt格式时 */
        TXTDataConvertor convertor = new TXTDataConvertor();
        convertor.readFile();
        /* 当客户数据是Excel格式时 */
        // ExcelDataConvertor convertor = new ExcelDataConvertor();
        // convertor.readFile();

        /* 新增转换类型或更换转换类型时，都要修改CustomerDAO源码 */
    }
}
