import SwiftUI

struct SecondaryActionButton_Previews: PreviewProvider {
    static var previews: some View {
        SecondaryActionButton(textPrimary: "Description",textSecondary: "Action")
    }
}

struct SecondaryActionButton: View {
    
    var textPrimary: String = ""
    var textSecondary: String = ""
    var icon: String = ""
    var action : () -> Void = {}
    
    var body: some View {
        Button(
            action: action,
            label: {
                HStack(alignment: .center, spacing: 5){
                    Text(textPrimary)
                        .font(.callout)
                        .foregroundColor(Color("darkGrey"))
                    Text(textSecondary)
                        .font(.callout)
                        .foregroundColor(Color("green"))
                    Image(icon)
                        .renderingMode(.template)
                        .foregroundColor(Color("darkGrey"))
                }
                .frame(maxWidth: .infinity, alignment: .leading)
            }
        )
        .padding(.vertical)
    }
}
