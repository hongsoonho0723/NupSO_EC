package controller;

import dto.FurnitureDTO;
import dto.ImgDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class FurnitureController implements Controller {
    FurnitureService furnitureService = new FurnitureServiceImpl();
    ColorService colorService = new ColorServiceImpl();
    SizeService sizeService = new SizeServiceImp();
    TextureService textureService = new TextureServiceImpl();
    ImgService imgService = new ImgServiceImpl();

    ReviewService reviewService = new ReviewServiceImpl();
    RevImgService revImgService = new RevImgServiceImpl();

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    public FurnitureController() throws IOException {}

    /*
    상품 상세 조회 페이지
     */
    public ModelAndView furnitureInfo(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("FurnitureController productInfo");

        String furnitureNumber = request.getParameter("furnitureNumber");
        try {
            FurnitureDTO furnitureDTO = furnitureService.selectFurnitureNumber(furnitureNumber);
            int furnitureSeq = furnitureService.findFurnitureSeqByNumber(furnitureNumber);

            List<String> colorList = colorService.selectColorByFurnitureSeq(furnitureSeq);
            List<String> sizeList = sizeService.selectSizeByFurnitureSeq(furnitureSeq);
            List<String> textureList = textureService.selectTextureByFurnitureSeq(furnitureSeq);

            List<ImgDTO> imgList = imgService.selectImg(furnitureSeq);
            List<ImgDTO> imgDetailList = imgService.selectDetailImg(furnitureSeq);

            List<ReivewDTO> reviewList = reviewService.selectAllReviews(furnitureSeq);
            int reviewSeq
            List<RevImgDTO> revImgList = revImgService.selectRevImg(reviewSeq)

            request.setAttribute("furnDTO", furnitureDTO);
            request.setAttribute("sizeList",sizeList);
            request.setAttribute("textureList",textureList);
            request.setAttribute("colorList",colorList);

            request.setAttribute("imgList",imgList);
            request.setAttribute("imgDetailList",imgDetailList);

            request.setAttribute("reviewList",reviewList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ModelAndView("furniture/furniture.jsp");
    }
}
