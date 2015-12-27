
package ParseCSVFile;

import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ParserCsvToXml {

    /**
     * @param args the command line arguments
     
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        int i=0;
        String inputFileName= "/home/17.CSV";
        String s[];
    
        Workbook wb= new HSSFWorkbook();
        Sheet sh= (Sheet) wb.createSheet("list1");
        Row row;
        Cell cell;
        
        try{
            CSVReader reader = new CSVReader(new FileReader(inputFileName));           
            while((s = reader.readNext()) !=null){
                row= sh.createRow(i);
                for(int j=0;j<s.length;j++){
                    cell= row.createCell(j);
                    cell.setCellValue(s[j]);
                }
                i+=1;
            }
        }
        catch(FileNotFoundException e){
        System.out.println("FileNotFound!");}
        catch (IOException e){}
        
        FileOutputStream fout= new FileOutputStream("/home/name.xls"); 
        wb.write(fout);
        fout.close();
        System.out.println("Ok!");
    }
    
}
    

