import SwiftUI

struct ActionButton_Previews: PreviewProvider {
    static var previews: some View {
        PrimaryActionButton()
    }
}
struct PrimaryActionButton: View {
    
    var text : String = ""
    var action : () -> Void = {}
    var background : Color = Color("yellow")

    var body: some View {
        Button(
            action: action,
            label : {
                Text(text)
                    .fontWeight(.bold)
                    .foregroundColor(.black)
                    .padding()
                    .frame(maxWidth: .infinity)
                    .background(background)
                    .cornerRadius(5)
            }
        )
        .padding(.vertical)
    }
}
