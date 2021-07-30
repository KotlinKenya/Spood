import SwiftUI

struct Error_Previews: PreviewProvider {
    static var previews: some View {
        Error(error: "Message")
    }
}

struct Error: View {
    
    var error: String
    
    var body: some View {
        Text(error)
            .font(.caption)
            .foregroundColor(.red)
            .frame(maxHeight: error.isEmpty ? 0 : nil)
    }
}
