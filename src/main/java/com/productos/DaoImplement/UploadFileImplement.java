package com.productos.DaoImplement;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.productos.modelo.Categorias;


@Service
public class UploadFileImplement {
	@Autowired
	CategoriasImp categoriasimp;

	List<Categorias> listCategorias = new ArrayList<>();

	public void guardarFileCategorias(MultipartFile file) throws IOException {
		System.out.print("FileC" + file.getOriginalFilename());
		InputStream externalfile = file.getInputStream();
		XSSFWorkbook libroCategoria = new XSSFWorkbook(externalfile);
		XSSFSheet hojaCategoria = libroCategoria.getSheetAt(0);
		Iterator<Row> rowsCategorias = hojaCategoria.iterator();
		Iterator<Cell> cellCategorias;
		Row row;
		Cell cell;
		rowsCategorias.next();
		while (rowsCategorias.hasNext()) {
			Categorias categoria = new Categorias();
			row = rowsCategorias.next();
			cellCategorias = row.cellIterator();
			while (cellCategorias.hasNext()) {
				cell = cellCategorias.next();
				int index = cell.getColumnIndex();
				switch (index) {
				case 0: {
					break;
				}
				case 1: {
					categoria.setNombreCategoria(cell.toString());
				}
				default:
					break;
				}
			}
			this.listCategorias.add(categoria);
		}
		libroCategoria.close();
        this.categoriasimp.saveAll(listCategorias);
		
	}
}
