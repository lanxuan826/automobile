//package com.automobile.util;
//import java.io.OutputStream;
//import java.util.Formatter;
//import java.util.List;
//
//import jxl.Workbook;
//import jxl.format.UnderlineStyle;
//import jxl.write.Label;
//import jxl.write.NumberFormat;
//import jxl.write.WritableCellFormat;
//import jxl.write.WritableFont;
//import jxl.write.WritableSheet;
//import jxl.write.WritableWorkbook;
//
//import com.automobile.model.User;
//
//import freemarker.template.utility.DateUtil;
//
//
///**
// * 统计系统报表导出的excel工具类
// * @author ly-wangweiqiang
// *
// */
//@SuppressWarnings("unchecked")
//public class ExcelUtil {
//
//	// excel标题的格式
//	private static WritableCellFormat titleFormat = new WritableCellFormat(new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
//			jxl.format.Colour.BLACK));
//
//	private static WritableFont detFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
//
//	// excedl数据的格式
//	private static WritableCellFormat detFormat = new WritableCellFormat(detFont);
//
//	// 用于Number的格式
//	public static WritableCellFormat numberFormat = new WritableCellFormat(detFont, new NumberFormat("0.00"));
//
//	public static Formatter formatter = new Formatter();
//
//	/**
//	 * 财务分析：导出入库登记统计报表Excel
//	 * 
//	 * @author <a href="mailto:wxpeng@163.com.com">王晓鹏</a>
//	 * @param cards
//	 * @param os
//	 * @param tableName
//	 * @throws Exception
//	 */
//
//	public static void writeVirWareCountExcel(List cards, OutputStream os, String tableName) throws Exception {
//		WritableWorkbook workbook = Workbook.createWorkbook(os);
//		WritableSheet sheet = workbook.createSheet(tableName + DateUtil.getSysDateString(), 0);
//		try {
//			Label lable = null;
//			int column = 0;
//			lable = new Label(column++, 0, "入库单号", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "商品编号", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "商品名称", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "商户编号", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "商户名称", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "供货商", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "进货价", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "商品类型", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "入库时间", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "入库数量", titleFormat);
//			sheet.addCell(lable);
//
//			if (cards != null && cards.size() > 0) {
//				int row = 0;
//				for (int i = 0; i < cards.size(); i++) {
//					Object[] obj = (Object[]) cards.get(i);
//					String id = (String) obj[0];
//					String productId = (String) obj[1];
//					String productName = (String) obj[2];
//					String storeId = (String) obj[3];
//					String suppliers = (String) obj[4];
//					Double purchasePrice = (Double) obj[5];
//					String createTime = (String) obj[6];
//
//					String storeName = "";
//
//					Store store = CategoryHelper.getStoreAttributes(storeId);
//					if (store != null) {
//						storeName = store.getStoreName();
//					}
//					int storageNum = BasStatHelper.getStorageNumByWareId(id);
//
//					column = 0;
//
//					lable = new Label(column++, row + 1, id, detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, productId, detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, productName, detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, storeId, detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, storeName, detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, suppliers, detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, purchasePrice + "", detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, "虚拟卡", detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, createTime, detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, storageNum + "", detFormat);
//					sheet.addCell(lable);
//
//					row = row + 1;
//				}
//			}
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			throw ex;
//		} finally {
//			if (workbook != null) {
//				workbook.write();
//				workbook.close();
//			}
//			if (os != null) {
//				os.close();
//			}
//		}
//	}
//
//	/**
//	 * 财务分析：导出入库分类统计报表Excel
//	 * 
//	 * @author <a href="mailto:wxpeng@163.com">王晓鹏</a>
//	 * @param cards
//	 * @param os
//	 * @param tableName
//	 * @throws Exception
//	 */
//
//	public static void writeVirWareCategoryExcel(List cards, OutputStream os, String tableName) throws Exception {
//		WritableWorkbook workbook = Workbook.createWorkbook(os);
//		WritableSheet sheet = workbook.createSheet(tableName + DateUtil.getSysDateString(), 0);
//		try {
//			Label lable = null;
//			int column = 0;
//			lable = new Label(column++, 0, "入库单号", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "商品编号", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "商品名称", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "商户编号", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "商户名称", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "供货商", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "商品类型", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "入库时间", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "进货价", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "进货价比例", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "入库数量", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "入库量比例", titleFormat);
//			sheet.addCell(lable);
//
//			double sumAllPurchasePrice = BasStatHelper.getStorageTotlePriceByWareId("all");
//			int sumAllNum = BasStatHelper.getStorageNumByWareId("all");
//
//			if (cards != null && cards.size() > 0) {
//				int row = 0;
//				for (int i = 0; i < cards.size(); i++) {
//					Object[] obj = (Object[]) cards.get(i);
//					String id = (String) obj[0];
//					String productId = (String) obj[1];
//					String productName = (String) obj[2];
//					String storeId = (String) obj[3];
//					String suppliers = (String) obj[4];
//					Double purchasePrice = (Double) obj[5];
//					String createTime = (String) obj[6];
//
//					String storeName = "";
//
//					Store store = CategoryHelper.getStoreAttributes(storeId);
//					if (store != null) {
//						storeName = store.getStoreName();
//					}
//					int storageNum = BasStatHelper.getStorageNumByWareId(id);
//
//					column = 0;
//					double conPurchasePrice = purchasePrice * storageNum;
//					String numPercent = BasStatHelper.percent(storageNum, sumAllNum);
//					String pricePercent = BasStatHelper.percent(conPurchasePrice, sumAllPurchasePrice);
//
//					lable = new Label(column++, row + 1, id, detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, productId, detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, productName, detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, storeId, detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, storeName, detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, suppliers, detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, "虚拟卡", detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, createTime, detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, purchasePrice + "", detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, pricePercent, detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, storageNum + "", detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, numPercent, detFormat);
//					sheet.addCell(lable);
//
//					row = row + 1;
//				}
//			}
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			throw ex;
//		} finally {
//			if (workbook != null) {
//				workbook.write();
//				workbook.close();
//			}
//			if (os != null) {
//				os.close();
//			}
//		}
//	}
//
//	/**
//	 * 财务分析报表：导出商品销售统计报表Excel
//	 * 
//	 * @author <a href="mailto:wxpeng@163.com">王晓鹏</a>
//	 * @param cards
//	 * @param os
//	 * @param tableName
//	 * @throws Exception
//	 */
//	public static void writeFinanceOrderSaleStatExcel(List result, OutputStream os, String tableName, String status) throws Exception {
//		WritableWorkbook workbook = Workbook.createWorkbook(os);
//		WritableSheet sheet = workbook.createSheet(tableName + DateUtil.getSysDateString(), 0);
//		try {
//			Label lable = null;
//			int column = 0;
//			lable = new Label(column++, 0, "商品编号", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "商品名称", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "商品类型", titleFormat);
//			sheet.addCell(lable);
//			// lable = new Label(column++, 0, "商户编号", titleFormat);
//			// sheet.addCell(lable);
//			lable = new Label(column++, 0, "商户名称", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "交易商品数", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "交易商品数比例", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "销售额(不含配送费)", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "销售额比例", titleFormat);
//			sheet.addCell(lable);
//			// lable = new Label(column++, 0, "成本", titleFormat);
//			// sheet.addCell(lable);
//			// lable = new Label(column++, 0, "毛利", titleFormat);
//			// sheet.addCell(lable);
//			// lable = new Label(column++, 0, "毛利比例", titleFormat);
//			// sheet.addCell(lable);
//
//			double totalSaleNum = BasStatHelper.getOrderTotalSaleNum(status);
//			double totalSalePrice = BasStatHelper.getOrderTotalSalePrice(status);
//			// 销售额小计
//			double totalAmount = 0;
//			// 交易商品数量小计
//			int jyCount = 0;
//			double totalMao = 0.00;
//			if (result != null && result.size() > 0) {
//				int row = 0;
//
//				for (int i = 0; i < result.size(); i++) {
//					Object[] obj = (Object[]) result.get(i);
//					totalMao = totalMao + ((Double) obj[2] - (Double) obj[3]);
//				}
//
//				for (int i = 0; i < result.size(); i++) {
//					Object[] obj = (Object[]) result.get(i);
//					String productId = (String) obj[0];
//
//					Product product = CategoryHelper.getProductAttributes(productId);
//
//					column = 0;
//					String productName = "";
//					String type = "";
//					String storeId = "";
//					// int pType = 0;
//					if (product != null) {
//						productName = product.getName();
//						if ("1".equals(product.getType() + "")) {
//							type = "虚拟卡";
//						} else {
//							type = "实物";
//						}
//						// pType = product.getType();
//
//						storeId = product.getStoreId();
//					}
//					String storeName = "";
//					Store store = StoreHelper.getStoreById(storeId);
//					if (store != null) {
//						storeName = store.getStoreName();
//					}
//					Integer quantity = ((Long) obj[1]).intValue();
//					Double totalprice = (Double) obj[2];
//					// Double esalesAmount = (Double) obj[3];
//					// Double maoli = totalprice - esalesAmount;
//					String percentNum = BasStatHelper.percent(quantity, totalSaleNum);
//					String percentPrice = BasStatHelper.percent(totalprice, totalSalePrice);
//					// String percentMaoli = BasStatHelper.percent(maoli,
//					// totalMao);
//
//					// String strEsalesAmount = esalesAmount + "";
//					// String strMaoli = maoli + "";
//					// if (pType != 1) {
//					// strEsalesAmount = "--";
//					// strMaoli = "--";
//					// percentMaoli = "--";
//					// }
//
//					lable = new Label(column++, row + 1, productId, detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, productName, detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, type, detFormat);
//					sheet.addCell(lable);
//
//					// lable = new Label(column++, row + 1, storeId, detFormat);
//					// sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, storeName, detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, quantity + "", detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, percentNum, detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, totalprice + "", detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, percentPrice, detFormat);
//					sheet.addCell(lable);
//
//					// lable = new Label(column++, row + 1, strEsalesAmount +
//					// "",
//					// detFormat);
//					// sheet.addCell(lable);
//					//
//					// lable = new Label(column++, row + 1, strMaoli + "",
//					// detFormat);
//					// sheet.addCell(lable);
//					//
//					// lable = new Label(column++, row + 1, percentMaoli,
//					// detFormat);
//					// sheet.addCell(lable);
//					jyCount = jyCount + quantity;
//					totalAmount = totalAmount + totalprice;
//					row = row + 1;
//				}
//				sheet.addCell(new Label(0, result.size() + 1, "小计：", titleFormat));
//				sheet.addCell(new Label(4, result.size() + 1, jyCount + "", detFormat));
//				sheet.addCell(new Label(6, result.size() + 1, totalAmount + "", numberFormat));
//
//			}
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			throw ex;
//		} finally {
//			if (workbook != null) {
//				workbook.write();
//				workbook.close();
//			}
//			if (os != null) {
//				os.close();
//			}
//		}
//	}
//
//	/**
//	 * 财务分析报表：导出商品汇总统计报表Excel
//	 * 
//	 * @author <a href="mailto:wxpeng@163.com">王晓鹏</a>
//	 * @param cards
//	 * @param os
//	 * @param tableName
//	 * @throws Exception
//	 */
//	public static void writeFinanceOrderSaleTotalStatExcel(List result, OutputStream os, String tableName, String status) throws Exception {
//		WritableWorkbook workbook = Workbook.createWorkbook(os);
//		WritableSheet sheet = workbook.createSheet(tableName + DateUtil.getSysDateString(), 0);
//		try {
//			Label lable = null;
//			int column = 0;
//			lable = new Label(column++, 0, "商品编号", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "商品名称", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "商品类型", titleFormat);
//			sheet.addCell(lable);
//			// lable = new Label(column++, 0, "商户编号", titleFormat);
//			// sheet.addCell(lable);
//			lable = new Label(column++, 0, "商户名称", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "交易商品数", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "销售额(不含配送费)", titleFormat);
//			sheet.addCell(lable);
//
//			double totalMao = 0.00;
//			// 销售额小计
//			double totalAmount = 0;
//			// 交易商品数量小计
//			int jyCount = 0;
//
//			if (result != null && result.size() > 0) {
//				int row = 0;
//
//				for (int i = 0; i < result.size(); i++) {
//					Object[] obj = (Object[]) result.get(i);
//					totalMao = totalMao + ((Double) obj[2] - (Double) obj[3]);
//				}
//
//				for (int i = 0; i < result.size(); i++) {
//					Object[] obj = (Object[]) result.get(i);
//					String productId = (String) obj[0];
//
//					Product product = CategoryHelper.getProductAttributes(productId);
//
//					column = 0;
//					String productName = "";
//					String type = "";
//					String storeId = "";
//
//					if (product != null) {
//						productName = product.getName();
//						if ("1".equals(product.getType() + "")) {
//							type = "虚拟卡";
//						} else {
//							type = "实物";
//						}
//						storeId = product.getStoreId();
//					}
//					String storeName = "";
//					Store store = CategoryHelper.getStoreAttributes(storeId);
//					if (store != null) {
//						storeName = store.getStoreName();
//					}
//					Integer quantity = new Long((Long) obj[1]).intValue();
//					Double totalprice = (Double) obj[2];
//
//					lable = new Label(column++, row + 1, productId, detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, productName, detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, type, detFormat);
//					sheet.addCell(lable);
//
//					// lable = new Label(column++, row + 1, storeId, detFormat);
//					// sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, storeName, detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, quantity + "", detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, totalprice + "", detFormat);
//					sheet.addCell(lable);
//					// 小计的数量和金额
//					jyCount = jyCount + quantity;
//					totalAmount = totalAmount + totalprice;
//
//					row = row + 1;
//				}
//
//				sheet.addCell(new Label(0, result.size() + 1, "小计：", titleFormat));
//				sheet.addCell(new Label(4, result.size() + 1, jyCount + "", detFormat));
//				sheet.addCell(new Label(5, result.size() + 1, formatter.format(totalAmount) + "", numberFormat));
//			}
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			throw ex;
//		} finally {
//			if (workbook != null) {
//				workbook.write();
//				workbook.close();
//			}
//			if (os != null) {
//				os.close();
//			}
//		}
//	}
//
//	/**
//	 * 财务分析报表：导出商品汇总统计报表Excel
//	 * 
//	 * @author <a href="mailto:wxpeng@163.com">王晓鹏</a>
//	 * @param cards
//	 * @param os
//	 * @param tableName
//	 * @throws Exception
//	 */
//	public static void writeFinanceStoreOrderSaleStatExcel(List result, OutputStream os, String tableName, HttpServletRequest request, ActionForm form) throws Exception {
//
//		SaleDetailStatForm storeSalesStatForm = (SaleDetailStatForm) form;
//
//		WritableWorkbook workbook = Workbook.createWorkbook(os);
//		WritableSheet sheet = workbook.createSheet(tableName + DateUtil.getSysDateString(), 0);
//		try {
//			Label lable = null;
//			int column = 0;
//			// lable = new Label(column++, 0, "商户编号", titleFormat);
//			// sheet.addCell(lable);
//			lable = new Label(column++, 0, "商户名称", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "实物(不含配送费)", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "实物(不含配送费,不含税)", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "配送费", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "配送费(不含税)", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "小计", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "小计(不含税)", titleFormat);
//			// sheet.addCell(lable);
//			// lable = new Label(column++, 0, "虚拟卡", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "优惠金额", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "合计", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "合计(不含税)", titleFormat);
//			sheet.addCell(lable);
//
//			// 实物(不含配送费)
//			double sum_sw = 0.00;
//			// 实物(不含配送费,不含税)
//			double sum_sw_no_ret = 0.00;
//			// 配送费
//			double sum_affixation = 0.00;
//			// 配送费(不含税)
//			double sum_affixation_no_ret = 0.00;
//			// 小计
//			double sum_sw_affixation = 0.00;
//			// 小计(不含税)
//			double sum_sw_affixation_no_ret = 0.00;
//			// 虚拟卡
//			// double sum_xnk = 0.00 ;
//			// 优惠金额
//			double sum_concessionsAmount = 0.00;
//			// 合计
//			double sum_sw_affixation_xnk = 0.00;
//			// 合计(不含税)
//			double sum_sw_affixation_xnk_no_ret = 0.00;
//
//			String storeId = "";
//			String storeName = "";
//			Double sw = null;
//			Double xnk = null;
//			Double affixation = null;
//			Double concessionsAmount = null;
//			// Double totalCost = null;
//			if (result != null && result.size() > 0) {
//				int row = 0;
//				// double sumSw = 0;
//				// double sumXnk = 0;
//				// double sumAffixantion = 0;
//				// double sumConcessionsAmount = 0;
//				// double sumTotalCost = 0;
//				for (int i = 0; i < result.size(); i++) {
//					Object[] allObj = (Object[]) result.get(i);
//					if (allObj[0] != null) {
//						storeId = (String) allObj[0];
//					}
//
//					Store store = com.aebiz.store.util.StoreHelper.getStoreById(storeId);
//					if (store != null) {
//						storeName = store.getStoreName();
//					}
//
//					sw = com.aebiz.bas.util.BasStatHelper.getSumProductCost(request, storeSalesStatForm, "0", storeId);
//					xnk = com.aebiz.bas.util.BasStatHelper.getSumProductCost(request, storeSalesStatForm, "1", storeId);
//					if (allObj[2] != null) {
//						affixation = (Double) allObj[2];
//					}
//					if (allObj[3] != null) {
//						concessionsAmount = (Double) allObj[3];
//					}
//					// if (allObj[4] != null) {
//					// totalCost = (Double) allObj[4];
//					// }
//					// sumSw = sumSw + sw;
//					// sumXnk = sumXnk + xnk;
//					// sumAffixantion = sumAffixantion + affixation;
//					// sumConcessionsAmount = sumConcessionsAmount
//					// + concessionsAmount;
//					// sumTotalCost = sumTotalCost + totalCost;
//
//					column = 0;
//					// 商户编号
//					// lable = new Label(column++, row + 1, storeId, detFormat);
//					// sheet.addCell(lable);
//					// 商户名称
//					lable = new Label(column++, row + 1, storeName, detFormat);
//					sheet.addCell(lable);
//					// 实物(不含配送费)
//					lable = new Label(column++, row + 1, formatter.format(sw), numberFormat);
//					sheet.addCell(lable);
//					// 实物(不含配送费,不含税)
//					lable = new Label(column++, row + 1, formatter.format(sw / 1.17) + "", numberFormat);
//					sheet.addCell(lable);
//					// 配送费
//					lable = new Label(column++, row + 1, formatter.format(affixation) + "", numberFormat);
//					sheet.addCell(lable);
//					// 配送费(不含税)
//					lable = new Label(column++, row + 1, formatter.format(affixation / 1.17) + "", numberFormat);
//					sheet.addCell(lable);
//					// 小计
//					lable = new Label(column++, row + 1, formatter.format(sw + affixation) + "", numberFormat);
//					sheet.addCell(lable);
//					// 小计(不含税)
//					lable = new Label(column++, row + 1, formatter.format((sw + affixation) / 1.17) + "", numberFormat);
//					sheet.addCell(lable);
//					// //虚拟卡
//					// lable = new Label(column++, row + 1,
//					// formatter.format(xnk)
//					// + "", numberFormat);
//					// sheet.addCell(lable);
//					// 优惠金额
//					lable = new Label(column++, row + 1, formatter.format(concessionsAmount), numberFormat);
//					sheet.addCell(lable);
//					// 合计
//					lable = new Label(column++, row + 1, formatter.format(sw + affixation + xnk) + "", numberFormat);
//					sheet.addCell(lable);
//					// 合计(不含税)
//					lable = new Label(column++, row + 1, formatter.format((sw + affixation) / 1.17 + xnk) + "", numberFormat);
//					sheet.addCell(lable);
//
//					// 导出表格下的小计统计栏
//					sum_sw = sum_sw + sw;
//					sum_sw_no_ret = sum_sw_no_ret + (sw / 1.17);
//					sum_affixation = sum_affixation + affixation;
//					sum_affixation_no_ret = sum_affixation_no_ret + (affixation / 1.17);
//					sum_sw_affixation = sum_sw_affixation + (sw + affixation);
//					sum_sw_affixation_no_ret = sum_sw_affixation_no_ret + ((sw + affixation) / 1.17);
//					// sum_xnk = sum_xnk + xnk ;
//					sum_concessionsAmount = sum_concessionsAmount + (concessionsAmount);
//					sum_sw_affixation_xnk = sum_sw_affixation_xnk + (sw + affixation + xnk);
//					sum_sw_affixation_xnk_no_ret = sum_sw_affixation_xnk_no_ret + ((sw + affixation) / 1.17 + xnk);
//
//					row = row + 1;
//				}
//				sheet.addCell(new Label(0, result.size() + 1, "小计：", titleFormat));
//				sheet.addCell(new Label(1, result.size() + 1, formatter.format(sum_sw) + "", numberFormat));
//				sheet.addCell(new Label(2, result.size() + 1, formatter.format(sum_sw_no_ret) + "", numberFormat));
//				sheet.addCell(new Label(3, result.size() + 1, formatter.format(sum_affixation) + "", numberFormat));
//				sheet.addCell(new Label(4, result.size() + 1, formatter.format(sum_affixation_no_ret) + "", numberFormat));
//				sheet.addCell(new Label(5, result.size() + 1, formatter.format(sum_sw_affixation) + "", numberFormat));
//				sheet.addCell(new Label(6, result.size() + 1, formatter.format(sum_sw_affixation_no_ret) + "", numberFormat));
//				// sheet.addCell(new
//				// Label(7,result.size()+1,formatter.format(sum_xnk)+"",numberFormat));
//				sheet.addCell(new Label(7, result.size() + 1, formatter.format(sum_concessionsAmount) + "", numberFormat));
//				sheet.addCell(new Label(8, result.size() + 1, formatter.format(sum_sw_affixation_xnk) + "", numberFormat));
//				sheet.addCell(new Label(9, result.size() + 1, formatter.format(sum_sw_affixation_xnk_no_ret) + "", numberFormat));
//			}
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			throw ex;
//		} finally {
//			if (workbook != null) {
//				workbook.write();
//				workbook.close();
//			}
//			if (os != null) {
//				os.close();
//			}
//		}
//	}
//
//	/**
//	 * 运营:导出商品销售统计
//	 * 
//	 * @author <a href="mailto:why.empire87@gmail.com">why王环宇</a>
//	 * @param cards
//	 * @param os
//	 * @param tableName
//	 * @throws Exception
//	 */
//	public static void writeProductSalesList(List list, OutputStream os, String tableName) throws Exception {
//
//		// 产生excel对象
//		WritableWorkbook workbook = Workbook.createWorkbook(os);
//		WritableSheet sheet = workbook.createSheet(tableName + DateUtil.getSysDateString(), 0);
//
//		try {
//			Label lable = null;
//
//			int column = 0;
//
//			lable = new Label(1, 0, tableName, titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "商品名称", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "购买数量", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "购买金额", titleFormat);
//			sheet.addCell(lable);
//
//			if (list != null && list.size() > 0) {
//				// 合计数据
//				int totalCount = 0;
//				double totalMoney = 0;
//				int row = 1;
//				for (int i = 0; i < list.size(); i++) {
//
//					Object[] obj = (Object[]) list.get(i);
//					String productId = (String) obj[0];
//					Integer count = (Integer) obj[1];
//					Double totalPrice = (Double) obj[2];
//
//					List odList = OrderHelper.getOrderDetailByProductId(productId);
//					OrderDetail od = (OrderDetail) odList.get(0);
//
//					column = 0;
//
//					lable = new Label(column++, row + 1, od.getProductName(), detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, count.toString(), numberFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, totalPrice.toString(), numberFormat);
//					sheet.addCell(lable);
//
//					row = row + 1;
//					totalCount = totalCount + count.intValue();
//					totalMoney = totalMoney + totalPrice.floatValue() * count.intValue();
//
//				}
//
//				// 合计
//				column = 0;
//				lable = new Label(column++, row + 1, "合计", titleFormat);
//				sheet.addCell(lable);
//
//				lable = new Label(column++, row + 1, totalCount + "", numberFormat);
//				sheet.addCell(lable);
//
//				lable = new Label(column++, row + 1, totalMoney + "", numberFormat);
//				sheet.addCell(lable);
//
//			}
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			throw ex;
//		} finally {
//			if (workbook != null) {
//				try {
//					workbook.write();
//					workbook.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			if (os != null) {
//				os.close();
//			}
//		}
//	}
//
//	/**
//	 * 导出商品销售明细统计
//	 * 
//	 * @author <a href="mailto:why.empire87@gmail.com">why王环宇</a>
//	 * @param list
//	 * @param os
//	 * @param tableName
//	 * @throws Exception
//	 */
//	public static void writeProductSalesDetailList(List list, OutputStream os, String tableName) throws Exception {
//
//		// 创建excel文件
//		WritableWorkbook workbook = Workbook.createWorkbook(os);
//		WritableSheet sheet = workbook.createSheet(tableName + DateUtil.getSysDateString(), 0);
//		try {
//			Label lable = null;
//			int column = 0;
//
//			lable = new Label(1, 0, tableName, titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "交易时间", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "买家ID", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "买家ID编号", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "单价", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "购买数量", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "购买金额", titleFormat);
//			sheet.addCell(lable);
//
//			if (list != null && list.size() > 0) {
//				// 合计数据
//				int totalCount = 0;
//				double totalMoney = 0;
//				int row = 1;
//				for (int i = 0; i < list.size(); i++) {
//					Object[] res = (Object[]) list.get(i);
//					String orderDate = (String) res[0];
//					String creator = (String) res[1];
//					String storeId = (String) res[2];
//					Double unitPrice = (Double) res[3];
//					Integer quantity = (Integer) res[4];
//					Double totalPrice = (Double) res[5];
//					column = 0;
//
//					lable = new Label(column++, row + 1, orderDate, detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, creator, detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, storeId, detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, unitPrice.toString(), numberFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, quantity.toString(), numberFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, totalPrice.toString(), numberFormat);
//					sheet.addCell(lable);
//
//					row = row + 1;
//					totalCount = quantity.intValue();
//					totalMoney = totalPrice.floatValue();
//				}
//
//				// 合计
//				column = 0;
//				lable = new Label(column++, row + 1, "合计", titleFormat);
//				sheet.addCell(lable);
//
//				lable = new Label(column++, row + 1, "", detFormat);
//				sheet.addCell(lable);
//
//				lable = new Label(column++, row + 1, "", detFormat);
//				sheet.addCell(lable);
//
//				lable = new Label(column++, row + 1, "".toString(), detFormat);
//				sheet.addCell(lable);
//
//				lable = new Label(column++, row + 1, totalCount + "", numberFormat);
//				sheet.addCell(lable);
//
//				lable = new Label(column++, row + 1, totalMoney + "", numberFormat);
//				sheet.addCell(lable);
//			}
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			throw ex;
//		} finally {
//			if (workbook != null) {
//				try {
//					workbook.write();
//					workbook.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			if (os != null) {
//				os.close();
//			}
//		}
//	}
//
//	/**
//	 * 订单查询统计结果导出
//	 * 
//	 * @param orderList
//	 * @param os
//	 * @param tableName
//	 * @throws Exception
//	 */
//	public static void writeOrderExcel(List orderList, OutputStream os, String tableName) throws Exception {
//		WritableWorkbook workbook = Workbook.createWorkbook(os);
//		WritableSheet sheet = workbook.createSheet(tableName + DateUtil.getSysDateString(), 0);
//		try {
//
//			// 一些临时变量，用于写到excel中
//			Label l = null;
//			// jxl.write.Number n = null;
//			// jxl.write.DateTime d = null;
//
//			// 剩下的事情，就是用上面的内容和格式创建一些单元格，再加到sheet中
//			int column = 0;
//			l = new Label(column++, 0, "订单号", titleFormat);
//			sheet.addCell(l);
//
//			l = new Label(column++, 0, "商户名", titleFormat);
//			sheet.addCell(l);
//
//			l = new Label(column++, 0, "商户名称", titleFormat);
//			sheet.addCell(l);
//
//			l = new Label(column++, 0, "订单时间", titleFormat);
//			sheet.addCell(l);
//			l = new Label(column++, 0, "状态", titleFormat);
//			sheet.addCell(l);
//
//			l = new Label(column++, 0, "会员名称", titleFormat);
//			sheet.addCell(l);
//
//			l = new Label(column++, 0, "支付方式", titleFormat);
//			sheet.addCell(l);
//
//			l = new Label(column++, 0, "订单总额(包含配送费)", titleFormat);
//			sheet.addCell(l);
//
//			// l = new Label(column++, 0, "完成交易额(包含配送费)", titleFormat);
//			// sheet.addCell(l);
//
//			l = new Label(column++, 0, "配送费", titleFormat);
//			sheet.addCell(l);
//
//			// l = new Label(column++, 0, "优惠金额", titleFormat);
//			// sheet.addCell(l);
//			//
//			// l = new Label(column++, 0, "代金券金额", titleFormat);
//			// sheet.addCell(l);
//			//
//			// l = new Label(column++, 0, "礼品卡金额", titleFormat);
//			// sheet.addCell(l);
//
//			if (orderList != null && orderList.size() > 0) {
//				double alltotalCost = 0.00;
//				double allaffixation = 0.00;
//
//				for (int i = 0; i < orderList.size(); i++) {
//					// 列数
//					column = 0;
//					// Order order = (Order) orderList.get(i);
//					Object[] o = (Object[]) orderList.get(i);
//
//					String orderId = (String) o[0];
//					String orderDate = (String) o[1];
//					Double totalCost = (Double) o[2];
//					String status = (String) o[3];
//					String userId = (String) o[4];
//					User user = UserHelper.getUserById(userId);
//					String userName = "";
//
//					if (user != null) {
//						userName = user.getUserAccount().getName();
//					}
//					String payType = (String) o[5];
//					// Double paid = (Double) o[6];
//					// String settleDate = (String) o[7];
//					String storeId = (String) o[8];
//					Double affixation = (Double) o[9];
//					// Double concessionsAmount = (Double) o[10];
//					// Double gcardAmount = (Double) o[11];
//					// Double pcardAmount = (Double) o[12];
//					l = new Label(column++, i + 1, orderId, detFormat);
//					sheet.addCell(l);
//
//					UserAccount ua = UserHelper.getUserAccountById(storeId);
//					Store store = StoreHelper.getStoreById(storeId);
//					if (ua != null) {
//						l = new Label(column++, i + 1, ua.getName(), detFormat);
//						sheet.addCell(l);
//					} else {
//						l = new Label(column++, i + 1, storeId, detFormat);
//						sheet.addCell(l);
//					}
//
//					if (store != null) {
//						l = new Label(column++, i + 1, store.getStoreName(), detFormat);
//						sheet.addCell(l);
//					} else {
//						l = new Label(column++, i + 1, "", detFormat);
//						sheet.addCell(l);
//					}
//
//					l = new Label(column++, i + 1, orderDate, detFormat);
//					sheet.addCell(l);
//					l = new Label(column++, i + 1, (String) OrderConst.bgStatusNames.get(status), detFormat);
//					sheet.addCell(l);
//
//					l = new Label(column++, i + 1, userName, detFormat);
//					sheet.addCell(l);
//					String payTypeName = "";
//					if ("01".equals(payType)) {
//						payTypeName = "现金支付";
//					} else if ("02".equals(payType)) {
//						payTypeName = "话费支付";
//					} else if ("03".equals(payType)) {
//						payTypeName = "货到付款";
//					}
//					l = new Label(column++, i + 1, payTypeName, detFormat);
//					sheet.addCell(l);
//					l = new Label(column++, i + 1, totalCost + "", numberFormat);
//					sheet.addCell(l);
//					// l = new Label(column++, i + 1, paid + "", numberFormat);
//					// sheet.addCell(l);
//					l = new Label(column++, i + 1, affixation + "", numberFormat);
//					sheet.addCell(l);
//					// l = new Label(column++, i + 1, concessionsAmount + "",
//					// numberFormat);
//					// sheet.addCell(l);
//					// l = new Label(column++, i + 1, gcardAmount + "",
//					// numberFormat);
//					// sheet.addCell(l);
//					// l = new Label(column++, i + 1, pcardAmount + "",
//					// numberFormat);
//					// sheet.addCell(l);
//
//					alltotalCost = alltotalCost + totalCost;
//					allaffixation = allaffixation + affixation;
//
//				}
//				sheet.addCell(new Label(0, orderList.size() + 1, "合计：", titleFormat));
//				sheet.addCell(new Label(7, orderList.size() + 1, formatter.format(alltotalCost), numberFormat));
//				sheet.addCell(new Label(8, orderList.size() + 1, formatter.format(allaffixation), numberFormat));
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			throw ex;
//		} finally {
//			if (workbook != null) {
//				workbook.write();
//				workbook.close();
//			}
//			if (os != null) {
//				os.close();
//			}
//
//		}
//	}
//
//	/**
//	 * 导出按商户统计的交易量
//	 * 
//	 * @param list
//	 * @param os
//	 * @param tableName
//	 * @throws Exception
//	 */
//	public static void writeStoreTrading(List list, OutputStream os, String tableName) throws Exception {
//
//		// 产生excel对象
//		WritableWorkbook workbook = Workbook.createWorkbook(os);
//		WritableSheet sheet = workbook.createSheet(tableName + DateUtil.getSysDateString(), 0);
//
//		try {
//			Label lable = null;
//			int column = 0;
//
//			// lable = new Label(column++, 0, "商户编号", titleFormat);
//			// sheet.addCell(lable);
//			lable = new Label(column++, 0, "商户名称", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "订单总数", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "订单交易额(含配送费)", titleFormat);
//			sheet.addCell(lable);
//			// lable = new Label(column++, 0, "完成交易额(含配送费)", titleFormat);
//			// sheet.addCell(lable);
//			lable = new Label(column++, 0, "配送费", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "优惠金额", titleFormat);
//			sheet.addCell(lable);
//			if (list != null && list.size() > 0) {
//				// 合计数据
//				// int totalCount = 0;
//				// double totalMoney = 0;
//				Integer allquantity = 0;
//				double alltotalPrice = 0.00;
//				double allaffixation = 0.00;
//				double allconcessionsAmount = 0.00;
//				int row = 0;
//				for (int i = 0; i < list.size(); i++) {
//					Object[] obj = (Object[]) list.get(i);
//					String storeId = (String) obj[0];
//					Integer quantity = ((Long) obj[1]).intValue();
//					Double totalPrice = (Double) obj[2];
//					// Double paid = (Double) obj[3];
//					Double affixation = (Double) obj[4];
//					Double concessionsAmount = (Double) obj[5];
//
//					Store store = StoreHelper.getStoreById(storeId);
//					String storeName = "";
//					if (store != null) {
//						storeName = store.getStoreName();
//					}
//
//					column = 0;
//
//					// lable = new Label(column++, row + 1, storeId, detFormat);
//					// sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, storeName, detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, quantity + "", numberFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, totalPrice + "", numberFormat);
//					sheet.addCell(lable);
//
//					// lable = new Label(column++, row + 1, paid + "",
//					// numberFormat);
//					// sheet.addCell(lable);
//					lable = new Label(column++, row + 1, affixation + "", numberFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, concessionsAmount + "", numberFormat);
//					sheet.addCell(lable);
//					// 合计
//					allquantity = allquantity + quantity;
//					alltotalPrice = alltotalPrice + totalPrice;
//					allaffixation = allaffixation + affixation;
//					allconcessionsAmount = allconcessionsAmount + concessionsAmount;
//
//					row = row + 1;
//				}
//				// 合计
//				sheet.addCell(new Label(0, list.size() + 1, "合计：", titleFormat));
//				sheet.addCell(new Label(1, list.size() + 1, allquantity + "", numberFormat));
//				sheet.addCell(new Label(2, list.size() + 1, formatter.format(alltotalPrice), numberFormat));
//				sheet.addCell(new Label(3, list.size() + 1, formatter.format(allaffixation), numberFormat));
//				sheet.addCell(new Label(4, list.size() + 1, formatter.format(allconcessionsAmount), numberFormat));
//			}
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			throw ex;
//		} finally {
//			if (workbook != null) {
//				try {
//					workbook.write();
//					workbook.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			if (os != null) {
//				os.close();
//			}
//		}
//	}
//
//	/**
//	 * 导出按商品统计的交易量
//	 * 
//	 * @param list
//	 * @param os
//	 * @param tableName
//	 * @throws Exception
//	 */
//	public static void writeProductTrading(List list, OutputStream os, String tableName) throws Exception {
//
//		// 产生excel对象
//		WritableWorkbook workbook = Workbook.createWorkbook(os);
//		WritableSheet sheet = workbook.createSheet(tableName + DateUtil.getSysDateString(), 0);
//
//		try {
//			Label lable = null;
//
//			int column = 0;
//
//			lable = new Label(column++, 0, "商品编号", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "商品名称", titleFormat);
//			sheet.addCell(lable);
//			// lable = new Label(column++, 0, "商户编号", titleFormat);
//			// sheet.addCell(lable);
//			lable = new Label(column++, 0, "商户名称", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "交易总额(不含配送费)", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "交易商品数", titleFormat);
//			sheet.addCell(lable);
//
//			if (list != null && list.size() > 0) {
//				// 合计数据
//				// int totalCount = 0;
//				// double totalMoney = 0;
//				double alltotalPrice = 0.00;
//				Integer allquantity = 0;
//				int row = 0;
//				for (int i = 0; i < list.size(); i++) {
//
//					Object[] obj = (Object[]) list.get(i);
//
//					String productId = (String) obj[0];
//					Double totalPrice = (Double) obj[1];
//					Integer quantity = ((Long) obj[2]).intValue();
//					Product product = CategoryHelper.getProductAttributes(productId);
//
//					String productName = "";
//					String storeId = "";
//					if (product != null) {
//						productName = product.getName();
//						storeId = product.getStoreId();
//					}
//
//					String storeName = "";
//					Store store = StoreHelper.getStoreById(storeId);
//					if (store != null) {
//						storeName = store.getStoreName();
//					}
//
//					column = 0;
//
//					lable = new Label(column++, row + 1, productId, detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, productName, detFormat);
//					sheet.addCell(lable);
//					// lable = new Label(column++, row + 1, storeId, detFormat);
//					// sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, storeName, detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, formatter.format(totalPrice) + "", detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, quantity + "", detFormat);
//					sheet.addCell(lable);
//					// 合计
//					alltotalPrice = alltotalPrice + totalPrice;
//					allquantity = allquantity + quantity;
//
//					row = row + 1;
//
//				}
//				sheet.addCell(new Label(0, list.size() + 1, "合计：", titleFormat));
//				sheet.addCell(new Label(3, list.size() + 1, formatter.format(alltotalPrice), numberFormat));
//				sheet.addCell(new Label(4, list.size() + 1, formatter.format(allquantity), detFormat));
//
//			}
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			throw ex;
//		} finally {
//			if (workbook != null) {
//				try {
//					workbook.write();
//					workbook.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			if (os != null) {
//				os.close();
//			}
//		}
//	}
//
//	/**
//	 * 导出按商品分类统计的交易量
//	 * 
//	 * @param list
//	 * @param os
//	 * @param tableName
//	 * @throws Exception
//	 */
//	public static void writeCategoryTrading(List list, OutputStream os, String tableName) throws Exception {
//
//		// 产生excel对象
//		WritableWorkbook workbook = Workbook.createWorkbook(os);
//		WritableSheet sheet = workbook.createSheet(tableName + DateUtil.getSysDateString(), 0);
//
//		try {
//			Label lable = null;
//
//			int column = 0;
//			lable = new Label(column++, 0, "频道(品类)名", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "交易总额(不含配送费)", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "交易商品数", titleFormat);
//			sheet.addCell(lable);
//
//			if (list != null && list.size() > 0) {
//				// 合计数据
//				// int totalCount = 0;
//				// double totalMoney = 0;
//				double alltotalPrice = 0.00;
//				Integer allquantity = 0;
//				int row = 0;
//				for (int i = 0; i < list.size(); i++) {
//
//					Object[] obj = (Object[]) list.get(i);
//
//					String categoryId = (String) obj[0];
//					Double totalPrice = (Double) obj[1];
//					Integer quantity = ((Long) obj[2]).intValue();
//
//					column = 0;
//
//					lable = new Label(column++, row + 1, ProductHelper.getProductCategoryFullName(categoryId, ">>", false), detFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, totalPrice + "", numberFormat);
//					sheet.addCell(lable);
//
//					lable = new Label(column++, row + 1, quantity + "", numberFormat);
//					sheet.addCell(lable);
//					// 合计
//					alltotalPrice = alltotalPrice + totalPrice;
//					allquantity = allquantity + quantity;
//
//					row = row + 1;
//				}
//				// 合计
//				sheet.addCell(new Label(0, list.size() + 1, "合计：", titleFormat));
//				sheet.addCell(new Label(1, list.size() + 1, formatter.format(alltotalPrice), numberFormat));
//				sheet.addCell(new Label(2, list.size() + 1, allquantity + "", detFormat));
//			}
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			throw ex;
//		} finally {
//			if (workbook != null) {
//				try {
//					workbook.write();
//					workbook.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			if (os != null) {
//				os.close();
//			}
//		}
//	}
//
//	/**
//	 * 进销存报表：导出进销存统计报表Excel
//	 * 
//	 * @author <a href="mailto:wxpeng@163.com">王晓鹏</a>
//	 * @param cards
//	 * @param os
//	 * @param tableName
//	 * @throws Exception
//	 */
//	public static void writeVirtualStorageStatExcel(List result, OutputStream os, String tableName) throws Exception {
//		WritableWorkbook workbook = Workbook.createWorkbook(os);
//		WritableSheet sheet = workbook.createSheet(tableName + DateUtil.getSysDateString(), 0);
//		try {
//			Label lable = null;
//			int column = 0;
//
//			// if (!"total".equals(type)) {
//			// lable = new Label(column++, 1, "商品名称", titleFormat);
//			// sheet.addCell(lable);
//			// }
//			lable = new Label(column++, 0, "", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "", titleFormat);
//			sheet.addCell(lable);
//
//			lable = new Label(column++, 0, "期初库存", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "", titleFormat);
//			sheet.addCell(lable);
//
//			lable = new Label(column++, 0, "当期购入", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "", titleFormat);
//			sheet.addCell(lable);
//
//			lable = new Label(column++, 0, "当期销售", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "", titleFormat);
//			sheet.addCell(lable);
//
//			lable = new Label(column++, 0, "当期撤出", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "", titleFormat);
//			sheet.addCell(lable);
//
//			lable = new Label(column++, 0, "期末库存", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "", titleFormat);
//			sheet.addCell(lable);
//			// 把 单元格（column, row）到单元格（column1, row1）进行合并。
//			// sheetWrite.mergeCells(column, row, column1, row1);
//
//			sheet.mergeCells(0, 0, 4, 0);
//			sheet.mergeCells(5, 0, 6, 0);
//			sheet.mergeCells(7, 0, 8, 0);
//			sheet.mergeCells(9, 0, 10, 0);
//			sheet.mergeCells(11, 0, 12, 0);
//			sheet.mergeCells(13, 0, 14, 0);
//
//			column = 0;
//
//			lable = new Label(column++, 1, "商户编号", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "商户名称", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "商品编号", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "商品名称", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "单价", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "数量", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "金额", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "数量", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "金额", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "数量", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "金额", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "数量", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "金额", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "数量", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "金额", titleFormat);
//			sheet.addCell(lable);
//
//			if (result != null && result.size() > 0) {
//				int row = 1;
//				for (int i = 0; i < result.size(); i++) {
//					Object[] obj = (Object[]) result.get(i);
//					String storeId = (String) obj[0];
//					column = 0;
//					String storeName = "";
//					Store store = com.aebiz.bas.util.CategoryHelper.getStoreAttributes(storeId);
//					if (store != null) {
//						storeName = store.getStoreName();
//					}
//
//					String productId = (String) obj[1];
//					String productName = "";
//					Product product = com.aebiz.bas.util.CategoryHelper.getProductAttributes(productId);
//					if (product != null) {
//						productName = product.getName();
//					}
//
//					double purchasePrice = 0;
//					if (obj[2] != null) {
//						purchasePrice = (Double) obj[2];
//					}
//
//					int qcCount = 0;
//					if (obj[3] != null) {
//						qcCount = (Integer) obj[3];
//					}
//
//					double qcPurchasePrice = 0;
//					if (obj[4] != null) {
//						qcPurchasePrice = (Double) obj[4];
//					}
//
//					int dqCount = 0;
//					if (obj[5] != null) {
//						dqCount = (Integer) obj[5];
//					}
//
//					double dqPurchasePrice = 0;
//					if (obj[6] != null) {
//						dqPurchasePrice = (Double) obj[6];
//					}
//
//					int dqxsCount = 0;
//					if (obj[7] != null) {
//						dqxsCount = (Integer) obj[7];
//					}
//
//					double dqxsPurchasePrice = 0;
//					if (obj[8] != null) {
//						dqxsPurchasePrice = (Double) obj[8];
//					}
//
//					int dqccCount = 0;
//					if (obj[9] != null) {
//						dqccCount = (Integer) obj[9];
//					}
//
//					double dqccPurchasePrice = 0;
//					if (obj[10] != null) {
//						dqccPurchasePrice = (Double) obj[10];
//					}
//
//					int qmCount = 0;
//					if (obj[11] != null) {
//						qmCount = (Integer) obj[11];
//					}
//
//					double qmPurchasePrice = 0;
//					if (obj[12] != null) {
//						qmPurchasePrice = (Double) obj[12];
//					}
//
//					lable = new Label(column++, row + 1, storeId, detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, storeName, detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, productId, detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, productName, detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, purchasePrice + "", detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, qcCount + "", detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, qcPurchasePrice + "", detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, dqCount + "", detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, dqPurchasePrice + "", detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, dqxsCount + "", detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, dqxsPurchasePrice + "", detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, dqccCount + "", detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, dqccPurchasePrice + "", detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, qmCount + "", detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, qmPurchasePrice + "", detFormat);
//					sheet.addCell(lable);
//					row = row + 1;
//				}
//			}
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			throw ex;
//		} finally {
//			if (workbook != null) {
//				workbook.write();
//				workbook.close();
//			}
//			if (os != null) {
//				os.close();
//			}
//		}
//	}
//
//	/**
//	 * 进销存报表：导出进销存统计报表Excel
//	 * 
//	 * @author <a href="mailto:wxpeng@163.com">王晓鹏</a>
//	 * @param cards
//	 * @param os
//	 * @param tableName
//	 * @throws Exception
//	 */
//	public static void writeVirtualStorageStatTotalExcel(List result, OutputStream os, String tableName) throws Exception {
//		WritableWorkbook workbook = Workbook.createWorkbook(os);
//		WritableSheet sheet = workbook.createSheet(tableName + DateUtil.getSysDateString(), 0);
//		try {
//			Label lable = null;
//			int column = 0;
//
//			// if (!"total".equals(type)) {
//			// lable = new Label(column++, 1, "商品名称", titleFormat);
//			// sheet.addCell(lable);
//			// }
//			lable = new Label(column++, 0, "", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "", titleFormat);
//			sheet.addCell(lable);
//
//			lable = new Label(column++, 0, "期初库存", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "", titleFormat);
//			sheet.addCell(lable);
//
//			lable = new Label(column++, 0, "当期购入", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "", titleFormat);
//			sheet.addCell(lable);
//
//			lable = new Label(column++, 0, "当期销售", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "", titleFormat);
//			sheet.addCell(lable);
//
//			lable = new Label(column++, 0, "当期撤出", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "", titleFormat);
//			sheet.addCell(lable);
//
//			lable = new Label(column++, 0, "期末库存", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 0, "", titleFormat);
//			sheet.addCell(lable);
//			// 把 单元格（column, row）到单元格（column1, row1）进行合并。
//			// sheetWrite.mergeCells(column, row, column1, row1);
//
//			sheet.mergeCells(0, 0, 1, 0);
//			sheet.mergeCells(2, 0, 3, 0);
//			sheet.mergeCells(4, 0, 5, 0);
//			sheet.mergeCells(6, 0, 7, 0);
//			sheet.mergeCells(8, 0, 9, 0);
//			sheet.mergeCells(10, 0, 11, 0);
//
//			column = 0;
//
//			lable = new Label(column++, 1, "商户编号", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "商户名称", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "数量", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "金额", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "数量", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "金额", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "数量", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "金额", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "数量", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "金额", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "数量", titleFormat);
//			sheet.addCell(lable);
//			lable = new Label(column++, 1, "金额", titleFormat);
//			sheet.addCell(lable);
//
//			if (result != null && result.size() > 0) {
//				int row = 1;
//				for (int i = 0; i < result.size(); i++) {
//					Object[] obj = (Object[]) result.get(i);
//					String storeId = (String) obj[0];
//					column = 0;
//					String storeName = "";
//					Store store = com.aebiz.bas.util.CategoryHelper.getStoreAttributes(storeId);
//					if (store != null) {
//						storeName = store.getStoreName();
//					}
//
//					int qcCount = 0;
//					if (obj[1] != null) {
//						qcCount = (Integer) obj[1];
//					}
//
//					double qcPurchasePrice = 0;
//					if (obj[2] != null) {
//						qcPurchasePrice = (Double) obj[2];
//					}
//
//					int dqCount = 0;
//					if (obj[3] != null) {
//						dqCount = (Integer) obj[3];
//					}
//
//					double dqPurchasePrice = 0;
//					if (obj[4] != null) {
//						dqPurchasePrice = (Double) obj[4];
//					}
//
//					int dqxsCount = 0;
//					if (obj[5] != null) {
//						dqxsCount = (Integer) obj[5];
//					}
//
//					double dqxsPurchasePrice = 0;
//					if (obj[6] != null) {
//						dqxsPurchasePrice = (Double) obj[6];
//					}
//
//					int dqccCount = 0;
//					if (obj[7] != null) {
//						dqccCount = (Integer) obj[7];
//					}
//
//					double dqccPurchasePrice = 0;
//					if (obj[8] != null) {
//						dqccPurchasePrice = (Double) obj[8];
//					}
//
//					int qmCount = 0;
//					if (obj[9] != null) {
//						qmCount = (Integer) obj[9];
//					}
//
//					double qmPurchasePrice = 0;
//					if (obj[10] != null) {
//						qmPurchasePrice = (Double) obj[10];
//					}
//
//					lable = new Label(column++, row + 1, storeId, detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, storeName, detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, qcCount + "", detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, qcPurchasePrice + "", detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, dqCount + "", detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, dqPurchasePrice + "", detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, dqxsCount + "", detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, dqxsPurchasePrice + "", detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, dqccCount + "", detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, dqccPurchasePrice + "", detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, qmCount + "", detFormat);
//					sheet.addCell(lable);
//					lable = new Label(column++, row + 1, qmPurchasePrice + "", detFormat);
//					sheet.addCell(lable);
//					row = row + 1;
//				}
//			}
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			throw ex;
//		} finally {
//			if (workbook != null) {
//				workbook.write();
//				workbook.close();
//			}
//			if (os != null) {
//				os.close();
//			}
//		}
//	}
//}
