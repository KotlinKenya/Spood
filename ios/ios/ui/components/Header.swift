import SwiftUI

struct Header_Previews: PreviewProvider {
    static var previews: some View {
        Header(title: "Title", subTitle: "Sub Title")
    }
}

struct Header: View {
    var title: String
    var subTitle: String
    
    var body: some View {
        VStack(alignment:  .leading, spacing: 5){
            Text(title)
                .font(.title)
                .fontWeight(.bold)
                .foregroundColor(Color("darkGreen"))
            
            Text(subTitle)
                .font(.subheadline)
                .fontWeight(.bold)
                .foregroundColor(Color("darkGrey"))
        }
        .frame(maxWidth: .infinity, alignment: .leading)
        .padding(.vertical)
    }
}
