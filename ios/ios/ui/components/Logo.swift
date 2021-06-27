import SwiftUI

struct Logo_Previews: PreviewProvider {
    static var previews: some View {
        Logo(tint: Color("green"), width: 50)
        Logo(paddingX: 120)
    }
}

struct Logo: View {
    var tint: Color = .black.opacity(0)
    var width: CGFloat = .infinity
    var paddingX: CGFloat = 0
    
    var body: some View {
        let renderingMode = tint == Color.black.opacity(0)
            ? Image.TemplateRenderingMode.original
            : Image.TemplateRenderingMode.template
        
        Image("logo")
            .resizable()
            .renderingMode(renderingMode)
            .aspectRatio(contentMode: .fit)
            .foregroundColor(tint)
            .frame(maxWidth: width)
            .padding(.horizontal, paddingX)
    }
}
