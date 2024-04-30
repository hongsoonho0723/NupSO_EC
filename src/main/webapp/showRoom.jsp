<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<jsp:include page="assets/common/user/header.jsp"/>

<script type="text/javascript">
    async function query(data) {
        const response = await fetch(
            "https://api-inference.huggingface.co/models/stabilityai/stable-diffusion-xl-base-1.0",
            {
                headers: { Authorization: "Bearer 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" },
                method: "POST",
                body: JSON.stringify(data),
            }
        );

        const imageBlob = await response.blob();
        const imageUrl = URL.createObjectURL(imageBlob);

        const imgElement = document.createElement('img');

        imgElement.src = imageUrl;
        imgElement.style.width = '100%';
        imgElement.style.height = 'auto';
        document.body.appendChild(imgElement);
        document.querySelector('h4').remove();
        return imageBlob;
    }
    const params = new URLSearchParams(window.location.search);
    const texture = params.get('texture');
    const category = params.get('category');
    const sofaName = params.get('sofaName');
    const description = params.get('description');
	
    //let prompt = "recommend a room that goes well with the "+sofaName+". The material is "+texture+
    //", and it's a "+category +description;
    let prompt = "recommend a room that goes well with the " + sofaName + ". The material is " + texture +
    ", and it's a " + category + description + ". Based on your current interior style,"+ 
    "we recommend selecting furniture that complements the " + sofaName + ". For example,"+ 
    "if your interior has a modern style,"+ 
    "you might consider sleek and minimalistic furniture pieces. "+
    "If it's more traditional, classic furniture with rich textures and warm colors could be a better fit"+
    ". Additionally, consider the size" 
    +"and layout of your room to ensure the furniture you choose fits well and enhances the overall aesthetic.";
    console.log(prompt)
    query({"inputs": prompt}).then((response) => {
        // Use image
    });
</script>

<h4 style="position: fixed;top: 50%; left: 50%;">이미지 생성까지 최대 10초가 소요됩니다.</h4>